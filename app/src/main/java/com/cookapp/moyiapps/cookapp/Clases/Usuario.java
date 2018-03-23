package com.cookapp.moyiapps.cookapp.Clases;

import java.util.List;

/**
 * Created by bmoyano on 22/3/2018.
 */

public class Usuario {

    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private List<Receta> misRecetas;
    private List<Receta> favortos;

    public List<Receta> getMisRecetas() {
        return misRecetas;
    }

    public void setMisRecetas(List<Receta> misRecetas) {
        this.misRecetas = misRecetas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Receta> getFavortos() {
        return favortos;
    }

    public void setFavortos(List<Receta> favortos) {
        this.favortos = favortos;
    }
}


