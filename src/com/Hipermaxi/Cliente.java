package com.Hipermaxi;

public class Cliente {

    private int id;
    private int efectivoEnCuenta;
    private int antiguedad;
    private String sexo;
    private String nombre;
    private int cantProductos = 0;
    private int cesta = 0;

    //constructor
    public Cliente (){
        this.id = 0;
        this.efectivoEnCuenta = 0;
        this.antiguedad = 0;
        this.sexo = "Undefined";
        this.nombre = "Unidentified";
    }

    public Cliente(int id,String name,int cash,int antiguedad, String sex){
        this.id = id;
        this.efectivoEnCuenta = cash;
        this.antiguedad = antiguedad;
        this.sexo = sex;
        this.nombre = name;
    }

    //setters
    public void setId(int x){
        this.id = x;
    }
    public void setEfectivoEnCuenta(int x){
        this.efectivoEnCuenta = x;
    }
    public void setAntiguedad(int x){
        this.antiguedad = x;
    }
    public void setSexo(String x){
        this.sexo = x;
    }
    public void setNombre(String x){
        this.nombre = x;
    }

    //getters
    public int getId() {
        return id;
    }
    public int getEfectivoEnCuenta() {
        return efectivoEnCuenta;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public String getSexo(){
        return sexo;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCantProductos(){
        return this.cantProductos;
    }
    public int getCesta(){
        return this.cesta;
    }

    //métodos

    public void seleccionarProducto(Articulo x){
        this.cantProductos ++;
        int precio = x.getPrecio();
        this.cesta += precio;
    }

    public void pagarProductos(){
        this.efectivoEnCuenta -= this.cesta;
    }

    public void report(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Saldo: "+efectivoEnCuenta);
        System.out.println("Cantida de productos: "+cantProductos);
        System.out.println("Total a pagar: "+cesta);
    }
}
