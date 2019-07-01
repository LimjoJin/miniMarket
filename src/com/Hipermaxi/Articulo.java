package com.Hipermaxi;

public class Articulo {
    private int id;
    private String nombre;
    private int precio;


    public Articulo(int id,String name,int price){
        this.id = id;
        this.nombre = name;
        this.precio = price;
    }

    //setters
    public void setId(int x){
        this.id = x;
    }
    public void setNombre(String x){
        this.nombre = x;
    }
    public void setPrecio(int x){
        this.precio = x;
    }


    //getters
    public int getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }

    //métodos
    public void mostrar(){
        System.out.println(id+"\t"+nombre+"\t"+precio);
    }

    public Articulo selfArticulo(){
        return this;
    }
}
