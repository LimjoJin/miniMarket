package com.Mercado.Locales;

import com.Mercado.ListaDoble.ListaDobleNormal;
import com.Mercado.Persona.Empleado;
import com.Mercado.Persona.Encargado;
import com.Mercado.Registro.RegistroDiario;

public class Local {
    private String idLocal;
    private String nombreLocal;
    private boolean ocupado;
    private double precio;
    //Los empleados los maneja el encargado el una listaDobleNromal
    //private Empleado[] emps = new Empleado[100];
    //private int nroEmp;
    private Encargado encargado;
    private ListaDobleNormal horas;
    private RegistroDiario registro;

    public Local() {
        this.nombreLocal = "";
        this.ocupado = false;
        this.precio = 0;
        //this.nroEmp = -1;
        encargado = new Encargado();
    }

    public Local(String nroLocal, boolean ocupado, double precio) {
        this.nombreLocal = nroLocal;
        this.ocupado = ocupado;
        this.precio = precio;
        //this.nroEmp = -1;
        encargado = new Encargado();
        horas = new ListaDobleNormal();
        registro = new RegistroDiario();
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nroLocal) {
        this.nombreLocal = nroLocal;
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

    public void agregarHorario(Horario ho){
        horas.adiFinal(ho);
    }

    public ListaDobleNormal getHoras() {
        return horas;
    }
}
