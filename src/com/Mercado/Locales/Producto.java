package com.Mercado.Locales;

public class Producto {
    private double precio;
    private String idProducto;
    private String nombre;

    public Producto() {
        this.precio = 0;
        this.idProducto = "";
        this.nombre = "";
    }

    public Producto(double precio, String idProducto, String nombre) {
        this.precio = precio;
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
