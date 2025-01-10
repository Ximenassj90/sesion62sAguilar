/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Ximena
 */
public class Conexion {
    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/bdexaaguilaris175"; // Cambia bdexaaguilaris175 si tu base de datos tiene otro nombre
    private static final String USER = "root"; // Cambia "root" si tu usuario es diferente
    private static final String PASSWORD = ""; // Cambia "" si tu contraseña no está vacía

    // Método para obtener una conexión
    public static Connection conectar() {
        try {
            // Establecer la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
            return null;
        }
        
    }
    
}
