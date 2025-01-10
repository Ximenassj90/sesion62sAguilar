/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ximena
 */
public class Equipo {
    private int idEquipo;
    private String marca;
    private String modelo;
    private int precio;

    // Constructor vacío
    public Equipo() {}

    // Constructor con parámetros
    public Equipo(int idEquipo, String marca, String modelo, int precio) {
        this.idEquipo = idEquipo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    // Getters y Setters
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
