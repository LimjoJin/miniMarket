package com.Mercado.ListaDoble;

public class NodoDoble {
	NodoDoble ant, sig;
	Object est;
	
	public NodoDoble() {
		
	}

	public NodoDoble getAnt() {
		return ant;
	}

	public void setAnt(NodoDoble ant) {
		this.ant = ant;
	}

	public NodoDoble getSig() {
		return sig;
	}

	public void setSig(NodoDoble sig) {
		this.sig = sig;
	}

	public Object getEst() {
		return est;
	}

	public void setEst(Object est) {
		this.est = est;
	}
	
	
}