package com.Mercado.ListaDoble;

public class ListaDobleCircular extends ListaDoble{

	@Override public int nroNodos() {
		int c = 0;
		if(!esVacia()) {
			NodoDoble rec = getCabecera();
			while(rec.getSig() != getCabecera()) {
				rec = rec.getSig();
				c++;
			}
			c++;
		}
		return c;
	}

	@Override public void adiPrimero(Object dato) {
		NodoDoble nd = new NodoDoble();
		nd.setEst(dato);
		adiPrimero(nd);
	}

	@Override public void adiPrimero(NodoDoble nd) {
		if(esVacia()) {
			nd.setAnt(nd);
			nd.setSig(nd);
		}else{
			nd.setAnt(getCabecera().getAnt());
			getCabecera().getAnt().setSig(nd);
			nd.setSig(getCabecera());
			getCabecera().setAnt(nd);
		}
		setCabecera(nd);
	}

	@Override public void adiFinal(Object dato) {
		NodoDoble nd = new NodoDoble();
		nd.setEst(dato);
		adiFinal(nd);
	}

	@Override public void adiFinal(NodoDoble nd) {
		if(esVacia()) {
			nd.setAnt(nd);
			nd.setSig(nd);
			setCabecera(nd);
		}else{
			nd.setAnt(getCabecera().getAnt());
			getCabecera().getAnt().setSig(nd);
			nd.setSig(getCabecera());
			getCabecera().setAnt(nd);
		}
	}

	@Override public Object eliPrimero() {
		Object dato = null;
		if(!esVacia()) {
			dato = getCabecera().getEst();
			if(nroNodos() == 1)
				setCabecera(null);
			else {
				NodoDoble nd = getCabecera();
				nd.getAnt().setSig(nd.getSig());
				nd.getSig().setAnt(nd.getAnt());
				setCabecera(nd.getSig());
				nd.setSig(null);
				nd.setAnt(null);
			}
		}
		return dato;
	}

	@Override public NodoDoble eliNodoPrimero() {
		NodoDoble nd = null;
		if(!esVacia()) {
			nd = getCabecera();
			if(nroNodos() == 1)
				setCabecera(null);
			else {
				nd.getAnt().setSig(nd.getSig());
				nd.getSig().setAnt(nd.getAnt());
				setCabecera(nd.getSig());
				nd.setSig(null);
				nd.setAnt(null);
			}
		}
		return nd;
	}

	@Override public Object eliFinal() {
		Object dato = null;
		if(!esVacia()) {
			if(nroNodos() == 1) {
				dato = getCabecera().getEst();
				setCabecera(null);
			}else {
				dato = getCabecera().getAnt().getEst();
				NodoDoble nd = getCabecera().getAnt();
				nd = getCabecera().getAnt();
				nd.getAnt().setSig(getCabecera());
				getCabecera().setAnt(nd.getAnt());
				nd.setSig(null);
				nd.setAnt(null);
			}
		}
		return dato;
	}

	@Override public NodoDoble eliNodoFinal() {
		NodoDoble nd = null;
		if(!esVacia()) {
			if(nroNodos() == 1) {
				nd = getCabecera();
				setCabecera(null);
			}else {
				nd = getCabecera().getAnt();
				nd.getAnt().setSig(getCabecera());
				getCabecera().setAnt(nd.getAnt());
				nd.setSig(null);
				nd.setAnt(null);
			}
		}
		return nd;
	}

	@Override public void leerPri(int n) {
		for(int i = 1; i <= n; i++) {
			NodoDoble nd = new NodoDoble();
			Estudiante est = new Estudiante();
			est.leer();
			nd.setEst(est);
			adiPrimero(nd);
		}
	}

	@Override public void leerFin(int n) {
		for(int i = 1; i <= n; i++) {
			NodoDoble nd = new NodoDoble();
			Estudiante est = new Estudiante();
			est.leer();
			nd.setEst(est);
			adiFinal(nd);
		}
	}

	@Override public void mostrar() {
		NodoDoble nd = getCabecera();
		if(!esVacia()) {
			while(nd.getSig() != getCabecera()){
				((Estudiante)nd.getEst()).mostrar();
				nd = nd.getSig();
			}
			((Estudiante)nd.getEst()).mostrar();			
		}else
			System.out.println("Lista vacia!");
	}

	public void mostrarEnteros() {
		NodoDoble nd = getCabecera();
		if(!esVacia()) {
			while(nd.getSig() != getCabecera()){
				System.out.println((Integer)nd.getEst());
				nd = nd.getSig();
			}
			System.out.println((Integer)nd.getEst());
		}else
			System.out.println("Lista vacia!");
	}
}