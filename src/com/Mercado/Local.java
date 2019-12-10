package com.Mercado;

public abstract class Local {
    private String nroLocal;
    private boolean esOcupado;
    private double precio;

    public Local() {
        this.nroLocal = "";
        this.esOcupado = false;
        this.precio = 0;
    }

    public Local(String nroLocal, boolean esOcupado, double precio) {
        this.nroLocal = nroLocal;
        this.esOcupado = esOcupado;
        this.precio = precio;
    }

    public String getNroLocal() {
        return nroLocal;
    }

    public void setNroLocal(String nroLocal) {
        this.nroLocal = nroLocal;
    }

    public boolean isEsOcupado() {
        return esOcupado;
    }

    public void setEsOcupado(boolean esOcupado) {
        this.esOcupado = esOcupado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
