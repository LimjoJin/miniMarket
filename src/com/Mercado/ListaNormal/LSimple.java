package com.Mercado.ListaNormal;

public abstract class LSimple {
    protected NodoS p;

    public LSimple() {
        p=null;
    }
    public boolean esVacia(){
        boolean b = p == null;
        return b;
    }
    abstract int nElem();
    abstract void adiFin(Object Dato);
    abstract void adiPrimero(Object Dato);
    abstract void adiDespuesKNodo(int k,Object Dato);
    abstract void adiAntesKNodo(int k,Object Dato);
    abstract Object eliFin();
    abstract Object eliPrimero();
    abstract Object eliKesiNodo(int k);
    abstract void mostrar();
}
