package com.Mercado.Persona;

import com.Mercado.ListaDoble.ListaDobleNormal;

public class Cliente extends Persona{
    private ListaDobleNormal carrito;
    private ListaDobleNormal compras;
    private String metodoPago;

    public Cliente() {
    }

    public Cliente(String id, String nombre) {
        super(id, nombre);
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }


}
