/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ximena
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public double calcularTotal() {
        return precio * cantidad;
    }
}
