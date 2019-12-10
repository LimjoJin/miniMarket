package com.Mercado.Persona;

import com.Mercado.Lectura.Leer;

public class Empleado extends Persona{
    private double salario;
    private double antiguedad;

    public Empleado() {
        super();
        this.salario = 0;
        this.antiguedad = 0;
    }

    public Empleado(double salario, double antiguedad,String id, String nombre) {
        super(id,nombre);
        this.salario = salario;
        this.antiguedad = antiguedad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(double antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void llenarDatos(){
        System.out.println("Ingrese el id:");
        String id = Leer.dato();
        this.setId(id);
        System.out.println("Ingrese el nombre:");
        String name = Leer.dato();
        this.setNombre(name);
        System.out.println("Ingrese salario:");
        double salary = Leer.datoDouble();
        this.setSalario(salary);
        System.out.println("Ingrese antiguedad");
        double ant = Leer.datoDouble();
        this.setAntiguedad(ant);
        System.out.println();
    }
}
