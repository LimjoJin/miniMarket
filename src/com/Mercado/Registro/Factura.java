package com.Mercado.Registro;

import com.Mercado.ListaDoble.ListaDobleNormal;
import com.Mercado.ListaDoble.NodoDoble;
import com.Mercado.Locales.Local;
import com.Mercado.Locales.Producto;
import com.Mercado.Persona.Cliente;
import com.Mercado.Persona.Empleado;

public class Factura {
    private Local local;
    private Empleado emp;
    private Cliente cli;
    private ListaDobleNormal productos;
    private double montoTotal;
    private String idFactura;

    public Factura() {
    }

    public Factura(Local local, Empleado emp, Cliente cli, ListaDobleNormal productos, String idFactura) {
        this.local = local;
        this.emp = emp;
        this.cli = cli;
        this.productos = productos;
        this.idFactura = idFactura;
        montoTotal = 0;
    }

    public double montoAPagar(){
        if (!productos.esVacia()){
            NodoDoble aux = productos.getCabecera();
            while (aux.getSig() != null){
                montoTotal += ((Producto)aux.getEst()).getPrecio();
                aux = aux.getSig();
            }
        } else {
            System.out.println("No existen productos a pagar");
        }
        return montoTotal;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ListaDobleNormal getProductos() {
        return productos;
    }

    public void setProductos(ListaDobleNormal productos) {
        this.productos = productos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }
}
