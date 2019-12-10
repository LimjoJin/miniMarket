package com.Mercado.ListaDoble;

public abstract class ListaDoble {
	protected NodoDoble p;
	public ListaDoble() {
		p = null;
	}
	public boolean esVacia() {
		return p == null;
	}
	public NodoDoble getCabecera() {
		return p;
	}
	public void setCabecera(NodoDoble x) {
		p = x;
	}
	public abstract int nroNodos();
	public abstract void adiPrimero(Object dato);
	public abstract void adiPrimero(NodoDoble nd);
	public abstract void adiFinal(Object dato);
	public abstract void adiFinal(NodoDoble nd);
	public abstract Object eliPrimero();
	public abstract NodoDoble eliNodoPrimero();
	public abstract Object eliFinal();
	public abstract NodoDoble eliNodoFinal();
	public abstract void leerPri(int n);
	public abstract void leerFin(int n);
	public abstract void mostrar();
}