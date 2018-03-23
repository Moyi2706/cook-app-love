package com.cookapp.moyiapps.cookapp.Clases;

/**
 * Created by bmoyano on 22/3/2018.
 */

public class Ingrediente {

    private int cantidad;
    private String nombre;


    public Ingrediente() {
    }

    public Ingrediente(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
