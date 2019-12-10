package com.Mercado.Persona;

public abstract class Persona {
    private String id;
    private String nombre;

    public Persona() {
        this.id = "";
        this.nombre = "not asigned";
    }

    Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
