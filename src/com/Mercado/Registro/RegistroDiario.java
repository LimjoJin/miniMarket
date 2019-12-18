package com.Mercado.Registro;

import com.Mercado.ListaDoble.ListaDobleNormal;

import java.time.LocalDate;

public class RegistroDiario {
    private ListaDobleNormal registroDia;
    private LocalDate fecha;
    private int nroVentas;

    public RegistroDiario() {
        this.fecha = LocalDate.now();
        this.nroVentas = 0;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void agregarVenta(Factura fact){
        this.nroVentas++;
        registroDia.adiFinal(fact);
        System.out.println("Venta registrada exitosamente");
    }
}
