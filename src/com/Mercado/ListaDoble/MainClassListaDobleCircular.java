package com.Mercado.ListaDoble;

public class MainClassListaDobleCircular {

	//1
	public static void intercabiarEstXY(ListaDobleCircular LC,String x, String y) {
		if(!LC.esVacia()) {
			NodoDoble rec = LC.getCabecera();
			NodoDoble recx = null, recy = null;
			while(rec.getSig() != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNombre().equals(x))
					recx = rec;
				if(((Estudiante)rec.getEst()).getNombre().equals(y))
					recy = rec;
				rec = rec.getSig();
			}

			//para el ultimo nodo
			if(((Estudiante)rec.getEst()).getNombre().equals(x))
				recx = rec;
			if(((Estudiante)rec.getEst()).getNombre().equals(y))
				recy = rec;
			//

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
	}

	//2 
	public static int contarAprobados(ListaDobleCircular LC) {
		int cant = 0;
		NodoDoble rec = LC.getCabecera();
		if(LC.nroNodos() != 0) {
			while(rec.getSig() != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNota() >= 51)
					cant++;
				rec = rec.getSig();
			}

			//para el �ltimo nodo
			if(((Estudiante)rec.getEst()).getNota() >= 51)
				cant++;
			//

		}		
		return cant;
	}

	public static double promedioNotaAprobados(ListaDobleCircular LC) {
		int sumNota = 0;
		int nroAprobados = contarAprobados(LC);
		if(nroAprobados != 0) {
			NodoDoble rec = LC.getCabecera();
			while(rec.getSig() != LC.getCabecera()) {
				int nota = ((Estudiante)rec.getEst()).getNota();
				if(nota >= 51)
					sumNota = sumNota + nota;
				rec = rec.getSig();
			}
			//Para el �ltimo nodo
			int nota = ((Estudiante)rec.getEst()).getNota();
			if(nota >= 51)
				sumNota = sumNota + nota;
			//
			return (float)sumNota / nroAprobados;
		}else {
			System.out.println("No existen estudiantes aprobados");
			return 0;
		}
	}

	//3
	public static int contarReprobados(ListaDobleCircular LC) {
		int cant = 0;
		NodoDoble rec = LC.getCabecera();
		if(LC.nroNodos() > 0) {
			while(rec.getSig() != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNota() < 51)
					cant++;
				rec = rec.getSig();
			}
			//para el �ltimo nodo
			if(((Estudiante)rec.getEst()).getNota() < 51)
				cant++;
			//
		}
		return cant;
	}
	//3.1
	public static void eliKesimoRepro1(ListaDobleCircular LC, int k) {
		int nroRep = contarReprobados(LC);//devuelve el total de reprobados de la lista
		if(k <= nroRep) {
			int contRep = 0;
			NodoDoble rec = LC.getCabecera();
			while(rec.getSig() != LC.getCabecera() && contRep != k) {
				if(((Estudiante)rec.getEst()).getNota() < 51) {
					contRep++;
					if(contRep != k)
						rec = rec.getSig();
					else {
						if(rec == LC.getCabecera()) 
							rec = LC.eliNodoPrimero();
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
			//Para el �ltimo nodo
			if(contRep != k) {
				if(((Estudiante)rec.getEst()).getNota() < 51) {
					contRep++;
					if(contRep != k)
						rec = rec.getSig();
					else {
						if(rec == LC.getCabecera()) 
							rec = LC.eliNodoPrimero();
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
				}
			}
			//
		}
	}

	//3.2
	public static void eliKesimoRepro2(ListaDobleCircular LC, int k) {
		int nroRep = contarReprobados(LC);//devuelve el total de reprobados de la lista
		if(k <= nroRep) {
			int contRep = 0;
			NodoDoble rec = LC.getCabecera();
			while(rec.getSig() != LC.getCabecera() && contRep != k) {
				if(((Estudiante)rec.getEst()).getNota() < 51) {
					contRep++;
					if(contRep != k)
						rec = rec.getSig();
					else {
						if(rec == LC.getCabecera()) 
							rec = LC.eliNodoPrimero();
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

			//para el �ltimo nodo
			if(k != contRep) {
				if(((Estudiante)rec.getEst()).getNota() < 51) {
					contRep++;
					if(contRep != k)
						rec = rec.getSig();
					else {
						if(rec == LC.getCabecera()) 
							rec = LC.eliNodoPrimero();
						else{//sin uso de nodos auxiliares del nodo a eliminar
							if(rec.getSig() != null)
								rec.getSig().setAnt(rec.getAnt());
							rec.getAnt().setSig(rec.getSig());
							rec.setSig(null);
							rec.setAnt(null);
						}
					}
				}
			}
			//
		}
	}

	//4.1
	public static void eliminarAbandonos1(ListaDobleCircular LC) {
		if(!LC.esVacia()) {
			NodoDoble rec = LC.getCabecera();
			while(rec.getSig() != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNota() < 20) {
					if(rec == LC.getCabecera()) {
						rec = LC.eliNodoPrimero();
						rec = LC.getCabecera();
					}else{//utilizando dos variables auxiliares
						NodoDoble q = rec.getAnt();
						NodoDoble s = rec.getSig();
						if(s != null)
							s.setAnt(q);
						q.setSig(s);
						rec.setSig(null);
						rec.setSig(null);
						rec = s;
					}
				}else
					rec = rec.getSig();
			}
			//Para el �ltimo nodo
			if(((Estudiante)rec.getEst()).getNota() < 20) {
				if(rec == LC.getCabecera()) {
					rec = LC.eliNodoPrimero();
					rec = LC.getCabecera();
				}else{//utilizando dos variables auxiliares
					NodoDoble q = rec.getAnt();
					NodoDoble s = rec.getSig();
					if(s != null)
						s.setAnt(q);
					q.setSig(s);
					rec.setSig(null);
					rec.setSig(null);
				}
			}
			//
		}
	}

	//4.2
	public static void eliminarAbandonos2(ListaDobleCircular LC) {
		if(!LC.esVacia()) {
			NodoDoble rec = LC.getCabecera();
			while(rec != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNota() < 20) {
					if(rec == LC.getCabecera()) {
						rec = LC.eliNodoPrimero();
						rec = LC.getCabecera();
					}else{//utilizando una variable auxiliar
						NodoDoble s = rec.getSig();
						if(s != null)
							s.setAnt(rec.getAnt());
						rec.getAnt().setSig(s);
						rec.setSig(null);
						rec.setSig(null);
						rec = s;
					}
				}else
					rec = rec.getSig();
			}
			//Para el �ltimo nodo
			if(((Estudiante)rec.getEst()).getNota() < 20) {
				if(rec == LC.getCabecera()) {
					rec = LC.eliNodoPrimero();
					rec = LC.getCabecera();
				}else{//utilizando una variable auxiliar
					NodoDoble s = rec.getSig();
					if(s != null)
						s.setAnt(rec.getAnt());
					rec.getAnt().setSig(s);
					rec.setSig(null);
					rec.setSig(null);
				}
			}
			//
		}
	}

	//4.3
	public static void eliminarAbandonos3(ListaDobleCircular LC) {
		if(!LC.esVacia()) {
			NodoDoble rec = LC.getCabecera();
			while(rec.getSig() != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNota() < 20) {
					if(rec == LC.getCabecera()) {
						rec = LC.eliNodoPrimero();
						rec = LC.getCabecera();
					}else{//sin usar variables auxiliares
						if(rec.getSig() != null)
							rec.getSig().setAnt(rec.getAnt());
						rec.getAnt().setSig(rec.getSig());
						rec = rec.getSig();
					}
				}else
					rec = rec.getSig();
			}
			//para el �ltimo nodo
			if(((Estudiante)rec.getEst()).getNota() < 20) {
				if(rec == LC.getCabecera()) {
					rec = LC.eliNodoPrimero();
					rec = LC.getCabecera();
				}else{//sin usar variables auxiliares
					if(rec.getSig() != null)
						rec.getSig().setAnt(rec.getAnt());
					rec.getAnt().setSig(rec.getSig());
				}
			}
			//
		}
	}


	//5
	public static void agregarKNodosAntesNotaX(ListaDobleCircular LC, int k, int x) {
		if(!LC.esVacia()) {
			NodoDoble rec = LC.getCabecera();
			while(rec.getSig() != LC.getCabecera()) {
				if(((Estudiante)rec.getEst()).getNota() >= x) {
					int t;
					if(rec == LC.getCabecera()) {
						NodoDoble nue = new NodoDoble();
						Estudiante est = new Estudiante();
						est.leer();
						nue.setEst(est);
						LC.adiPrimero(nue);
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

			//Para el �ltimo nodo
			if(((Estudiante)rec.getEst()).getNota() >= x) {
				int t;
				if(rec == LC.getCabecera()) {
					NodoDoble nue = new NodoDoble();
					Estudiante est = new Estudiante();
					est.leer();
					nue.setEst(est);
					LC.adiPrimero(nue);
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
			//
		}
	}


	public static void main(String[] args) {

		System.out.println("Para Lista doble circular");

		ListaDobleCircular ldc = new ListaDobleCircular();
		System.out.print("Nro de nodos: ");
		int n = Leer.datoInt();
		ldc.leerFin(n);
		ldc.mostrar();

		/*
		System.out.println("1. Dados dos nombres de estudiantes con nombres  'x' e 'y', intercambiar "
				+ "a los estudiantes entre ellos si es que existen en la lista. Se asume que los nombres "
				+ "son �nicos en la lista");
		System.out.print("Nombre x: ");
		String x = Leer.dato();
		System.out.print("Nombre y: ");
		String y = Leer.dato();
		intercabiarEstXY(ldc, x, y);
		ldc.mostrar();
		 */


		/*
		System.out.println("2. Mostrar la nota promedio de los estudiantes aprobados");
		double prom = promedioNotaAprobados(ldc);
		System.out.println("Promedio de nota de aprobados: " + prom);
		 */

		/*
		System.out.println("3.1 Eliminar al k-esimo estudiante reprobado de la lista si es que existe");
		int k;
		do {
			System.out.print("Nro k-esimo: ");
			k = Leer.datoInt();
		}while(k <= 0);
		eliKesimoRepro1(ldc, k);
		ldc.mostrar();
		 */

		/*
		System.out.println("3.2 Eliminar al k-esimo estudiante reprobado de la lista si es que existe");
		int k;
		do {
			System.out.print("Nro k-esimo: ");
			k = Leer.datoInt();
		}while(k <= 0);
		eliKesimoRepro2(ldc, k);
		ldc.mostrar();
		 */


		/*
		System.out.println("4.1 eliminar a los estudiantes que abandonaron la materia (nota < 20)");
		eliminarAbandonos1(ldc);
		ldc.mostrar();
		 */


		/*
		System.out.println("4.2 eliminar a los estudiantes que abandonaron la materia (nota < 20)");
		eliminarAbandonos2(ldc);
		ldc.mostrar();
		 */


		/*
		System.out.println("4.3 eliminar a los estudiantes que abandonaron la materia (nota < 20)");
		eliminarAbandonos3(ldc);
		ldc.mostrar();
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
		agregarKNodosAntesNotaX(ldc, k, x);
		ldc.mostrar();
		 */


	}

}