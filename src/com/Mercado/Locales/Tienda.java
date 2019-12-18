package com.Mercado.Locales;

import com.Mercado.ListaDoble.ListaDobleNormal;
import com.Mercado.ListaDoble.NodoDoble;

public class Tienda extends Local{
    private ListaDobleNormal productos;
    private String tipoProductos;

    public Tienda() {
        super();
        tipoProductos = "";
    }

    public Tienda(String nroLocal, boolean ocupado, double precio, ListaDobleNormal productos) {
        super(nroLocal, ocupado, precio);
        this.productos = productos;
        tipoProductos = "";
    }

    public Tienda(String nroLocal, boolean ocupado, double precio) {
        super(nroLocal, ocupado, precio);
        tipoProductos = "";
    }

    public String getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(String tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    public void agregarProducto(double precio, String idProducto, String nombre) {
        Producto pro = new Producto(precio,idProducto,nombre);
        productos.adiFinal(pro);
    }

    public Object eliminarProducto(String id){
        //Devuelve Producto
        NodoDoble aux = productos.getCabecera();
        while(aux.getSig() != null){
            Producto pro = (Producto) aux.getEst();
            if ((pro.getIdProducto()).equals(id)){
                (aux.getAnt()).setSig(aux.getSig());
                (aux.getSig()).setAnt(aux.getAnt());
                return pro;
            }
            aux = aux.getSig();
        }
        return null;
    }
}
