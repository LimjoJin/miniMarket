package com.Mercado.ListaDoble;

public class ListaDobleNormal extends ListaDoble{

	public ListaDobleNormal() {
		super();
	}
	
	@Override public int nroNodos() {
		int c = 0;
		NodoDoble rec = getCabecera();
		while(rec != null){
	            c++;
	            rec = rec.getSig();
		}
		return c;
	}

	@Override public void adiPrimero(Object dato) {
		NodoDoble nodo = new NodoDoble();
		nodo.setEst(dato);
		adiPrimero(nodo);
	}

	@Override public void adiPrimero(NodoDoble nd) {
		nd.setSig(getCabecera());
		if(getCabecera() != null)
			getCabecera().setAnt(nd);
		setCabecera(nd);
	}

	@Override public void adiFinal(Object dato) {
		NodoDoble nodo = new NodoDoble();
		nodo.setEst(dato);
		adiFinal(nodo);		
	}

	@Override public void adiFinal(NodoDoble nd) {
		if(esVacia()){
			nd.setSig(getCabecera());
			setCabecera(nd);
		}else{
			NodoDoble rec = getCabecera();
			while(rec.getSig() != null)
				rec = rec.getSig();
			rec.setSig(nd);
			nd.setAnt(rec);
		}
	}

	@Override public Object eliPrimero() {
		Object dato = null;
		if(!esVacia()) {
			dato = getCabecera().getEst();
			if(nroNodos() == 1) 
				setCabecera(null);
			else{
				NodoDoble x = getCabecera();
				setCabecera(x.getSig());
				getCabecera().setAnt(null);
				x.setSig(null);
			}
		}else
			System.out.println("Lista vacia!!");
		return dato;
	}

	@Override public NodoDoble eliNodoPrimero() {
		NodoDoble x = null;
		if(!esVacia()) {
			x = getCabecera();
			if(nroNodos() == 1)
				setCabecera(null);
			else{
				setCabecera(x.getSig());
				getCabecera().setAnt(null);
				x.setSig(null);
			}
		}else
			System.out.println("Lista vacia!!!");
		return x;
	}

	@Override public Object eliFinal() {
		Object dato = null;
		if(!esVacia()) {
			if(nroNodos() == 1) {
				dato = getCabecera().getEst();
				setCabecera(null);                                                                                                                                                                                                                                                                                                                        
			}else{
				NodoDoble x = getCabecera();
				while(x.getSig() != null)
					x = x.getSig();
				dato = x.getEst();
				NodoDoble rec = getCabecera();
				while(rec.getSig() != x)
					rec = rec.getSig();
				rec.setSig(null);
				x.setAnt(null);
			}
		}else
			System.out.println("Lista vacia!!!");
		return dato;
	}

	@Override public NodoDoble eliNodoFinal() {
		NodoDoble x = null;
		if(!esVacia()) {
			if(nroNodos() == 1) {
				x = getCabecera();
				setCabecera(null);                                                                                                                                                                                                                                                                                                                        
			}else{
				x = getCabecera();
				while(x.getSig() != null)
					x = x.getSig();
				NodoDoble rec = getCabecera();
				while(rec.getSig() != x)
					rec = rec.getSig();
				rec.setSig(null);
				x.setAnt(null);
			}
		}else
			System.out.println("Lista vacia!!!");
		return x;
	}

	@Override public void leerPri(int n) {
		for(int i = 1; i <= n; i++){
			Estudiante est = new Estudiante();
			est.leer();
			adiPrimero(est);
		}
	}

	@Override public void leerFin(int n) {
		for(int i = 1; i <= n; i++){
			Estudiante est = new Estudiante();
			est.leer();
			adiFinal(est);
		}
	}

	@Override public void mostrar() {
		NodoDoble rec = getCabecera();
		if(rec != null) {
			System.out.println("----- Desplegando lista -----");
			while(rec != null){
				( (Estudiante)rec.getEst() ).mostrar();
				rec = rec.getSig();
			}
			System.out.println("------------------------------");
		}else
			System.out.println("Lista vacia!!!");
	}
	public void mostrarEnteros() {
		NodoDoble rec = getCabecera();
		if(rec != null) {
			System.out.println("----- Desplegando lista -----");
			while(rec != null){
				System.out.println((Integer)rec.getEst());
				rec = rec.getSig();
			}
			System.out.println("------------------------------");
		}else
			System.out.println("Lista vacia!!!");
	}


}