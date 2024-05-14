package com.example.ropatecmi.ui.home;

import java.io.Serializable;

// Definición de la clase Producto, implementa Serializable para poder pasar objetos entre actividades
public class Producto implements Serializable {

    private String nombre; // Nombre del producto
    private String precio; // Precio del producto
    private String talla; // Talla del producto

    // Constructor para inicializar un producto con un nombre, precio y talla
    public Producto(String nombre, String precio, String talla) {
        this.nombre = nombre;
        this.precio = precio;
        this.talla = talla;
    }

    // Método para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el precio del producto
    public String getPrecio() {
        return precio;
    }

    // Método para establecer el precio del producto
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    // Método para obtener la talla del producto
    public String getTalla() {
        return talla;
    }

    // Método para establecer la talla del producto
    public void setTalla(String talla) {
        this.talla = talla;
    }
}
