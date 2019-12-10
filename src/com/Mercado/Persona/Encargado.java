package com.Mercado.Persona;

import com.Mercado.ListaDoble.ListaDobleNormal;
import com.Mercado.ListaDoble.NodoDoble;

public class Encargado extends Empleado {
    private ListaDobleNormal listaEmp; // Registro de empleados

    public Encargado() {
    }

    public Encargado(double salario, double antiguedad, String id, String nombre, ListaDobleNormal listaEmp) {
        super(salario, antiguedad, id, nombre);
        this.listaEmp = listaEmp;
    }

    public void registrarEmpleado(){
        Empleado emp = new Empleado();
        emp.llenarDatos();
        listaEmp.adiFinal(emp);
    }

    public void editarDatosEmpleado(String id){
        NodoDoble aux = listaEmp.getCabecera();
        while (aux.getSig() != null){
            if ( (((Empleado)(aux.getEst())).getId()).equals(id)){

            }
            aux = aux.getSig();
        }
    }

    public Empleado retirarEmp(String id){
        NodoDoble aux = listaEmp.getCabecera();
        while (aux.getSig() != null){
            if ( (((Empleado)(aux.getEst())).getId()).equals(id)){
                (aux.getAnt()).setSig(aux.getSig());
                (aux.getSig()).setAnt(aux.getAnt());
                return (Empleado) (aux.getEst());
            }
            aux = aux.getSig();
        }
        System.out.println("No se encontró el empleado");
        return null;
    }

    public void incrementarSueldo(String id,double incremento){
        NodoDoble aux = listaEmp.getCabecera();
        while (aux.getSig() != null){
            if ( (((Empleado)(aux.getEst())).getId()).equals(id) ){
                ((Empleado)(aux.getEst())).setSalario( ((Empleado)(aux.getEst())).getSalario() + incremento );
                break;
            }
            aux = aux.getSig();
        }
        System.out.println("No se realizó el incremento debido a que no se encontró el empleado con id: "+id);
    }
}
