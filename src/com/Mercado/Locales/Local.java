package com.Mercado.Locales;

import com.Mercado.Persona.Empleado;
import com.Mercado.Persona.Encargado;

public abstract class Local {
    private String nroLocal;
    private boolean ocupado;
    private double precio;
    //Los empleados los maneja el encargado el una listaDobleNromal
    //private Empleado[] emps = new Empleado[100];
    //private int nroEmp;
    private Encargado encargado = new Encargado();

    public Local() {
        this.nroLocal = "";
        this.ocupado = false;
        this.precio = 0;
        //this.nroEmp = -1;
    }

    public Local(String nroLocal, boolean ocupado, double precio) {
        this.nroLocal = nroLocal;
        this.ocupado = ocupado;
        this.precio = precio;
        //this.nroEmp = -1;
    }

    public String getNroLocal() {
        return nroLocal;
    }

    public void setNroLocal(String nroLocal) {
        this.nroLocal = nroLocal;
    }

    public boolean EsOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean esOcupado) {
        this.ocupado = esOcupado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*
    public Empleado getEmpleado(int pos){
        if (pos > nroEmp) {
            return null;
        } else {
            return emps[pos];
        }
    }
    */

    /*
    public void agregarEmpleado(Empleado emp){
        nroEmp++;
        emps[nroEmp] = emp;
    }
    */

    /*
    public Empleado eliminarEmpleadoPos(int pos){
        if (pos > nroEmp) {
            return null;
        } else {
            Empleado aux =  emps[pos];
            emps[pos] = null;
            return aux;
        }
    }
    */

    /*
    public Empleado eliminarEmpleadoId(String id){
        for (int i = 0; i < emps.length; i++) {
            Empleado aux = emps[i];
            if ((aux.getId()).equals(id)){
                emps[i] = null;
                return aux;
            }
        }
        return null;
    }
    */
}
