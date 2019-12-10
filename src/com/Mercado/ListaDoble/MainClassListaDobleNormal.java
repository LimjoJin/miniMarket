package com.Mercado.ListaDoble;

public class MainClassListaDobleNormal {

	//1
	public static void intercabiarEstXY(ListaDobleNormal L,String x, String y) {
		NodoDoble rec = L.getCabecera();
		NodoDoble recx = null, recy = null;
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNombre().equals(x))
				recx = rec;
			if(((Estudiante)rec.getEst()).getNombre().equals(y))
				recy = rec;
			rec = rec.getSig();
		}
		if(recx != null && recy != null) {
			if(recx != recy) {
				Estudiante aux_est = new Estudiante();
				aux_est.setNombre(((Estudiante)recx.getEst()).getNombre());
				aux_est.setNota(((Estudiante)recx.getEst()).getNota());
				recx.setEst(recy.getEst());
				recy.setEst(aux_est);
			}else
				System.out.println("Los nodos son iguales");
		}else
			System.out.println("Alguno de los nombres introducidos no se encuentra en la lista");
	}

	//2 
	public static int contarAprobados(ListaDobleNormal L) {
		int cant = 0;
		NodoDoble rec = L.getCabecera();
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNota() >= 51)
				cant++;
			rec = rec.getSig();
		}
		return cant;
	}

	public static double promedioNotaAprobados(ListaDobleNormal L) {
		int sumNota = 0;
		int nroAprobados = contarAprobados(L);
		if(nroAprobados != 0) {
			NodoDoble rec = L.getCabecera();
			while(rec != null) {
				int nota = ((Estudiante)rec.getEst()).getNota();
				if(nota >= 51)
					sumNota = sumNota + nota;
				rec = rec.getSig();
			}
			return (float)sumNota / nroAprobados;
		}else {
			System.out.println("No existen estudiantes aprobados");
			return 0;
		}
	}


	//3
	public static int contarReprobados(ListaDobleNormal L) {
		int cant = 0;
		NodoDoble rec = L.getCabecera();
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNota() < 51)
				cant++;
			rec = rec.getSig();
		}
		return cant;
	}

	//3.1
	public static void eliKesimoRepro1(ListaDobleNormal L, int k) {
		int nroRep = contarReprobados(L);//devuelve el total de reprobados de la lista
		if(k <= nroRep) {
			int contRep = 0;
			NodoDoble rec = L.getCabecera();
			while(rec != null && contRep != k) {
				if(((Estudiante)rec.getEst()).getNota() < 51) {
					contRep++;
					if(contRep != k)
						rec = rec.getSig();
					else {
						if(rec == L.getCabecera()) 
							rec = L.eliNodoPrimero();
						else{//usar dos variables auxiliares anterior(q) y posterior(s) del nodo a eliminar
							NodoDoble q = rec.getAnt();
							NodoDoble s = rec.getSig();
							if(s != null)
								s.setAnt(q);
							q.setSig(s);
							rec.setSig(null);
							rec.setAnt(null);
						}
					}
				}else
					rec = rec.getSig();
			}
		}
	}

	//3.2
	public static void eliKesimoRepro2(ListaDobleNormal L, int k) {
		int nroRep = contarReprobados(L);//devuelve el total de reprobados de la lista
		if(k <= nroRep) {
			int contRep = 0;
			NodoDoble rec = L.getCabecera();
			while(rec != null && contRep != k) {
				if(((Estudiante)rec.getEst()).getNota() < 51) {
					contRep++;
					if(contRep != k)
						rec = rec.getSig();
					else {
						if(rec == L.getCabecera()) 
							rec = L.eliNodoPrimero();
						else{//sin uso de nodos auxiliares del nodo a eliminar
							if(rec.getSig() != null)
								rec.getSig().setAnt(rec.getAnt());
							rec.getAnt().setSig(rec.getSig());
							rec.setSig(null);
							rec.setAnt(null);
						}
					}
				}else
					rec = rec.getSig();
			}
		}
	}

	//4.1
	public static void eliminarAbandonos1(ListaDobleNormal L) {
		NodoDoble rec = L.getCabecera();
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNota() < 20) {
				if(rec == L.getCabecera()) {
					rec = L.eliNodoPrimero();
					rec = L.getCabecera();
				}else{//utilizando dos variables auxiliares
					NodoDoble q = rec.getAnt();
					NodoDoble s = rec.getSig();
					if(s != null)
						s.setAnt(q);
					q.setSig(s);
					rec.setSig(null);
					rec = s;
				}
			}else
				rec = rec.getSig();
		}
	}

	//4.2
	public static void eliminarAbandonos2(ListaDobleNormal L) {
		NodoDoble rec = L.getCabecera();
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNota() < 20) {
				if(rec == L.getCabecera()) {
					rec = L.eliNodoPrimero();
					rec = L.getCabecera();
				}else{//utilizando una variable auxiliar
					NodoDoble s = rec.getSig();
					if(s != null)
						s.setAnt(rec.getAnt());
					rec.getAnt().setSig(s);
					rec.setSig(null);
					rec = s;
				}
			}else
				rec = rec.getSig();
		}
	}

	//4.3
	public static void eliminarAbandonos3(ListaDobleNormal L) {
		NodoDoble rec = L.getCabecera();
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNota() < 20) {
				if(rec == L.getCabecera()) {
					rec = L.eliNodoPrimero();
					rec = L.getCabecera();
				}else{//sin usar variables auxiliares
					if(rec.getSig() != null)
						rec.getSig().setAnt(rec.getAnt());
					rec.getAnt().setSig(rec.getSig());
					rec = rec.getSig();
				}
			}else
				rec = rec.getSig();
		}
	}
	
	
	//5
	public static void agregarKNodosAntesNotaX(ListaDobleNormal L, int k, int x) {
		NodoDoble rec = L.getCabecera();
		while(rec != null) {
			if(((Estudiante)rec.getEst()).getNota() >= x) {
				int t;
				if(rec == L.getCabecera()) {
					NodoDoble nue = new NodoDoble();
					Estudiante est = new Estudiante();
					est.leer();
					nue.setEst(est);
					L.adiPrimero(nue);
					t = 2;
				}else 
					t = 1;
				NodoDoble q = rec.getAnt();
				for(int i = t; i <= k; i++) {
					NodoDoble nuevo = new NodoDoble();
					Estudiante est = new Estudiante();
					est.leer();
					nuevo.setEst(est);
					nuevo.setAnt(q);
					nuevo.setSig(rec);
					q.setSig(nuevo);
					rec.setAnt(nuevo);
					q = nuevo;
				}
			}
			rec = rec.getSig();
		}
	}
	
	//6
	public static void dividirReprobadosAprobados(ListaDobleNormal LA, ListaDobleNormal LR) {//La lista LA en principio es la lista principal, la lista LR de inicio esta vacia 
		int n = LA.nroNodos(); //en una variable n se obtiene el nro de elementos que tiene la lista LA de inicio
		for(int i = 1; i <= n; i++) {
			NodoDoble nd = LA.eliNodoPrimero();//se va sacando uno por uno los nodos de la lista LA utilizando eliNodoPrimero
			if(((Estudiante)nd.getEst()).getNota() >= 51)
				LA.adiFinal(nd);   //se utiliza el metodo adiFinal que admite nodos
			else
				LR.adiFinal(nd);   //se utiliza el metodo adiFinal que admite nodos
		}
	}
	
	//7
	public static void agregarNodo(ListaDobleNormal L, NodoDoble n) {
		NodoDoble rec = L.getCabecera();
		boolean esMayor = true;
		boolean esDistinto = true;
		while(rec != null && esMayor == true && esDistinto == true) {
			if(((Estudiante)rec.getEst()).getNota() < ((Estudiante)n.getEst()).getNota()) {
				if(((Estudiante)rec.getEst()).getNota() != ((Estudiante)n.getEst()).getNota())
					rec = rec.getSig();
				else
					esDistinto = false;
			}else {
				if(((Estudiante)rec.getEst()).getNota() == ((Estudiante)n.getEst()).getNota())
					esDistinto = false;
				esMayor = false;
			}
		}
		if(rec == null && esDistinto == true)
			L.adiFinal(n);
		else {
			if(rec == L.getCabecera() && esDistinto == true)
				L.adiPrimero(n);
			else {
				if(esDistinto == true && esMayor == false) {
					NodoDoble q = rec.getAnt();
					rec.setAnt(n);
					q.setSig(n);
					n.setSig(rec);
					n.setAnt(q);
				}else
					System.out.println("El nodo no se agrega");
			}
		}
	}
	
	//8
	public static void llevarKUltimos(ListaDobleNormal L, int k) {
		int n = L.nroNodos();
		int s = n - k;
		for(int i = 1; i <= s; i++) {
			NodoDoble nd = L.eliNodoPrimero();
			L.adiFinal(nd);
		}
	}
	
	//9
	public static void agregarKnuevosNodosLuegoK(ListaDobleNormal L, int k) {
		NodoDoble rec = L.getCabecera();
		for(int i = 1; i < k ; i++)
			rec = rec.getSig();
		for(int i = 1; i <= k; i++) {
			NodoDoble nuevo = new NodoDoble();
			Estudiante est = new Estudiante();
			est.leer();
			nuevo.setEst(est);
			if(rec.getSig() != null) {
				rec.getSig().setAnt(nuevo);
			}
			nuevo.setSig(rec.getSig());
			nuevo.setAnt(rec);
			rec.setSig(nuevo);
			rec = nuevo;
		}
	}
	
	//10
	public static void insertarNuevaListaLuegoIesimo(ListaDobleNormal L, int i) {
		NodoDoble rec = L.getCabecera();
		for(int k = 1; k < i; k++) 
			rec = rec.getSig();
		ListaDobleNormal listaNueva = new ListaDobleNormal();
		System.out.print("Nro de nodos: ");
		int n = Leer.datoInt();
		listaNueva.leerFin(n);
		if(!listaNueva.esVacia()) {
			NodoDoble rec2 = listaNueva.getCabecera();
			while(rec2.getSig() != null)
				rec2 = rec2.getSig();
			if(rec.getSig() != null)
				rec.getSig().setAnt(rec2);
			rec2.setSig(rec.getSig());
			listaNueva.getCabecera().setAnt(rec);
			rec.setSig(listaNueva.getCabecera());
		}else
			System.out.println("No se cre� ninguna lista");
	}
	
	public static void ordenarKPrimeros(ListaDobleNormal L, int k) {
		if(L.nroNodos() > 1) {
			NodoDoble rec1 = L.getCabecera();
			NodoDoble rec2 = rec1.getSig();
			for(int i = 1; i < k; i++) {
				for(int j = i + 1; j <= k;j++) {
					if((((Estudiante)rec2.getEst()).getNota()) > (((Estudiante)rec1.getEst()).getNota())) {
						Estudiante aux = new Estudiante();
						aux.setNombre(((Estudiante)rec2.getEst()).getNombre());
						aux.setNota(((Estudiante)rec2.getEst()).getNota());
						((Estudiante)rec2.getEst()).setNota(((Estudiante)rec1.getEst()).getNota());
						((Estudiante)rec2.getEst()).setNombre(((Estudiante)rec1.getEst()).getNombre());
						((Estudiante)rec1.getEst()).setNota(aux.getNota());
						((Estudiante)rec2.getEst()).setNombre(aux.getNombre());
					}
					rec2 = rec2.getSig();
				}
				rec1 = rec1.getSig();
				rec2 = rec1.getSig();
			}
		}
	}
	public static void main(String []args) {
		
		System.out.println("Para Lista doble normal");
		
		ListaDobleNormal ldn = new ListaDobleNormal();
		System.out.print("Nro de nodos: ");
		int n = Leer.datoInt();
		ldn.leerFin(n);
		ldn.mostrar();
		int k;
		do {
			System.out.print("Nro k-esimo: ");
			k = Leer.datoInt();
		}while(k <= 0 || k > ldn.nroNodos());
		ordenarKPrimeros(ldn, k);
		ldn.mostrar();
		
		/*
		System.out.println("1. Dados dos nombres de estudiantes con nombres  'x' e 'y', intercambiar "
				+ "a los estudiantes entre ellos si es que existen en la lista. Se asume que los nombres "
				+ "son �nicos en la lista");
		System.out.print("Nombre x: ");
		String x = Leer.dato();
		System.out.print("Nombre y: ");
		String y = Leer.dato();
		intercabiarEstXY(ldn, x, y);
		ldn.mostrar();
		 */


		/*
		System.out.println("2. Mostrar la nota promedio de los estudiantes aprobados");
		double prom = promedioNotaAprobados(ldn);
		System.out.println("Promedio de nota de aprobados: " + prom);
		 */


		/*
		System.out.println("3.1 Eliminar al k-esimo estudiante reprobado de la lista si es que existe");
		int k;
		do {
			System.out.print("Nro k-esimo: ");
			k = Leer.datoInt();
		}while(k <= 0);
		eliKesimoRepro1(ldn, k);
		ldn.mostrar();
		 */


		/*
		System.out.println("3.2 Eliminar al k-esimo estudiante reprobado de la lista si es que existe");
		int k;
		do {
			System.out.print("Nro k-esimo: ");
			k = Leer.datoInt();
		}while(k <= 0);
		eliKesimoRepro2(ldn, k);
		ldn.mostrar();
		 */

		
		/*
		System.out.println("4.1 eliminar a los estudiantes que abandonaron la materia (nota < 20)");
		eliminarAbandonos1(ldn);
		ldn.mostrar();
		*/
		
		
		/*
		System.out.println("4.2 eliminar a los estudiantes que abandonaron la materia (nota < 20)");
		eliminarAbandonos2(ldn);
		ldn.mostrar();
		*/
		
		
		/*
		System.out.println("4.3 eliminar a los estudiantes que abandonaron la materia (nota < 20)");
		eliminarAbandonos3(ldn);
		ldn.mostrar();
		*/
		
		
		/*
		System.out.println("5. Agregar k nuevos estudiantes antes de aquellos que tienen nota mayor o igual a x");
		int k,x;
		do {
			System.out.print("Introducir k: ");
			k = Leer.datoInt();
		}while(k <= 0);
		do {
			System.out.print("Introducir nota x: ");
			x = Leer.datoInt();
		}while(x < 0 || x > 100);
		agregarKNodosAntesNotaX(ldn, k, x);
		ldn.mostrar();
		*/
		
		
		/*
		System.out.println("6. Dividir la lista en dos: aprobados y reprobados. Para lo cual no debe crear nuevos nodos");
		ListaDobleNormal ldn2 = new ListaDobleNormal();
		dividirReprobadosAprobados(ldn, ldn2);
		ldn.mostrar();]]]
		ldn2.mostrar();
		*/
		
		
		/*
		System.out.println("7. Suponiendo que la lista est� ordenada por la nota de forma ascendente y son �nicas,"
				+ " insertar un nuevo estudiante en la lista manteniendo el orden de la misma, si la nota ya existe,"
				+ " entonces no se introduce al estudiante");
		NodoDoble nd = new NodoDoble();
		Estudiante est = new Estudiante();
		est.leer();
		nd.setEst(est);
		agregarNodo(ldn, nd);
		ldn.mostrar();
		*/
		
		/*
		System.out.println("8. Llevar los k ultimos nodos al inicio de la lista sin crear nodos nuevos (validar k antes)");//2 formas
		int k;
		do {
			k = Leer.datoInt();
		}while(k <= 0 || k > ldn.nroNodos());
		llevarKUltimos(ldn, k);
		ldn.mostrar();
		*/
		
		/*
		System.out.println("9. Crear k nuevos nodos luego del k-esimo nodo (validar k antes)");
		
		int k;
		do {
			k = Leer.datoInt();
		}while(k <= 0 || k > ldn.nroNodos());
		agregarKnuevosNodosLuegoK(ldn, k);
		ldn.mostrar();
		*/
		
		
		/*
		System.out.println("10. Insertar una nueva lista despu�s del i-esimo nodo (validar i antes)");
		int i;
		do {
			i = Leer.datoInt();
		}while(i <= 0 || i > ldn.nroNodos());
		insertarNuevaListaLuegoIesimo(ldn, i);
		ldn.mostrar();
		 */
		
	}

}