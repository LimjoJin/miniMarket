package com.Mercado.Locales;

public class Platillo extends Producto{
    private String[] ingredientes = new String[100];
    private int nroIngredientes;

    public Platillo(double precio, String idProducto, String nombre) {
        super(precio, idProducto, nombre);
        this.nroIngredientes = -1;
    }

    public String getIngrediente(int pos){
        if(pos > nroIngredientes){
            System.out.println("Numero de ingrediente incorrecto");
            return "";
        } else {
            return ingredientes[pos];
        }
    }
    public void setIngrediente(int pos,String ingredient){
        ingredientes[pos] = ingredient;
    }

    public int getNroIngredientes() {
        return nroIngredientes;
    }

    public void setNroIngredientes(int nroIngredientes) {
        this.nroIngredientes = nroIngredientes;
    }

    public void agregarNuevoIngrediente(String ing){
        nroIngredientes++;
        ingredientes[nroIngredientes] = ing;
    }
}
