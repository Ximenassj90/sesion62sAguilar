/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import db.Conexion;
import java.sql.Connection;
/**
 *
 * @author Ximena
 */
public class PruebaConexion {
   public static void main(String[] args) {
        // Intentar conectar con la base de datos
        Connection conn = Conexion.conectar();
        if (conn != null) {
            System.out.println("Conexión exitosa con la base de datos.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    } 
}
