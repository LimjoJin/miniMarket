package com.Mercado.ListaDoble;

public class Estudiante {
	private String nombre;
	private int nota;
	
	public Estudiante() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public void leer() {
		System.out.print("Nombre del estudiante: ");
		nombre = Leer.dato();
		System.out.print("Nota del estudiante: ");
		nota = Leer.datoInt();
		System.out.println();
	}
	
	public void mostrar() {
		System.out.println("\nNombre: " + nombre + "\nnota: " + nota);
	}
}