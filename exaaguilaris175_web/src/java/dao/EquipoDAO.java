package dao;

import db.Conexion;
import model.Equipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para gestionar operaciones de la tabla "equipos".
 */
public class EquipoDAO {

    /**
     * Obtiene la lista de equipos registrados en la base de datos.
     * @return Lista de objetos Equipo.
     */
    public List<Equipo> obtenerEquipos() {
        List<Equipo> listaEquipos = new ArrayList<>();
        Connection conn = Conexion.conectar();
        String sql = "SELECT * FROM equipos";

        if (conn == null) {
            System.out.println("La conexión a la base de datos no se pudo establecer.");
            return listaEquipos; // Retornar lista vacía en lugar de null.
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Equipo equipo = new Equipo(
                    rs.getInt("idEquipo"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("precio")
                );
                listaEquipos.add(equipo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener equipos: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return listaEquipos;
    }

    /**
     * Agrega un nuevo equipo a la base de datos.
     * @param equipo Objeto Equipo con los datos a registrar.
     * @return true si el equipo fue agregado correctamente, false en caso contrario.
     */
public boolean agregarEquipo(Equipo equipo) {
    Connection conn = Conexion.conectar();
    String sql = "INSERT INTO equipos (marca, modelo, precio) VALUES (?, ?, ?)";

    if (conn == null) {
        System.out.println("La conexión a la base de datos no se pudo establecer.");
        return false;
    }

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, equipo.getMarca());
        stmt.setString(2, equipo.getModelo());
        stmt.setInt(3, equipo.getPrecio());

        int filas = stmt.executeUpdate();

        // Realizar commit si la operación fue exitosa
        conn.commit();

        return filas > 0;
    } catch (SQLException e) {
        System.out.println("Error al agregar equipo: " + e.getMessage());

        // Hacer rollback si ocurre algún error
        try {
            conn.rollback();
        } catch (SQLException rollbackEx) {
            System.out.println("Error al realizar rollback: " + rollbackEx.getMessage());
        }

        return false;
    } finally {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

}
