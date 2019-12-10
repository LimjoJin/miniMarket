package com.Mercado.ListaNormal;

public class NodoS {
    Object Dato;
    NodoS Sig;

    public NodoS() {
        Sig = null;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object dato) {
        Dato = dato;
    }

    public NodoS getSig() {
        return Sig;
    }

    public void setSig(NodoS sig) {
        Sig = sig;
    }
}
