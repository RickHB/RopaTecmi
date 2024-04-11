package com.example.ropatecmi.ui.home;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private String precio;
    private String talla;

    public Producto(String nombre, String precio, String talla) {
        this.nombre = nombre;
        this.precio = precio;
        this.talla = talla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
