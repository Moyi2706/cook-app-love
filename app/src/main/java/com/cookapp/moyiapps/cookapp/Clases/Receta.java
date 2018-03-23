package com.cookapp.moyiapps.cookapp.Clases;


import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by bmoyano on 22/3/2018.
 */

public class Receta {

    private List<Ingrediente> ingredientes;
    private String preparacion;
    private int tiempoprep;
    private int tiempococ;
    private String titulo;
    private Categoria categoria;
    private int imagen;


    public Receta(List<Ingrediente> ingredientes, String preparacion, int tiempoprep, int tiempococ, String titulo, Categoria categoria,int imagen) {
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.tiempoprep = tiempoprep;
        this.tiempococ = tiempococ;
        this.titulo = titulo;
        this.categoria = categoria;
        this.imagen= imagen;
    }



    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public int getTiempoprep() {
        return tiempoprep;
    }

    public void setTiempoprep(int tiempoprep) {
        this.tiempoprep = tiempoprep;
    }

    public int getTiempococ() {
        return tiempococ;
    }

    public void setTiempococ(int tiempococ) {
        this.tiempococ = tiempococ;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
