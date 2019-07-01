package com.Hipermaxi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        int total = 8;

        Articulo toy1 = new Articulo(101,"Carro",230);
        Articulo toy2 = new Articulo(102,"Muñeca",320);
        Articulo toy3 = new Articulo(103,"Ajedrez",450);
        Articulo toy4 = new Articulo(104,"Pelota",370);

        toy1.mostrar();
        toy2.mostrar();
        toy3.mostrar();
        toy4.mostrar();

        Articulo food1 = new Articulo(105,"Cebolla",20);
        Articulo food2 = new Articulo(106,"Papa",30);
        Articulo food3 = new Articulo(107,"Tomate",30);
        Articulo food4 = new Articulo(108,"Lechuga",20);

        food1.mostrar();
        food2.mostrar();
        food3.mostrar();
        food4.mostrar();

        Cliente client1 = new Cliente(501,"Sara",1530,0,"female");
        Cliente client2 = new Cliente(502,"Adam",1630,6,"male");
        Cliente client3 = new Cliente(503,"Colt",1750,3,"male");
        Cliente client4 = new Cliente(504,"Carol",2130,1,"female");

        Articulo [] listaArticulos = new Articulo[total];
        listaArticulos[0] = toy1;
        listaArticulos[1] = toy2;
        listaArticulos[2] = toy3;
        listaArticulos[3] = toy4;
        listaArticulos[4] = food1;
        listaArticulos[5] = food2;
        listaArticulos[6] = food3;
        listaArticulos[7] = food4;

        System.out.println();
        System.out.println("Bienvenido");
        int exit = 0;
        while (exit == 0){
            System.out.println();
            System.out.println("[1]Seguir comprando");
            System.out.println("[2]Pagar");
            System.out.println("[3]Reporte");
            System.out.println("[4]Salir");
            exit = tecla.nextInt();

            while (exit<1 || exit>4){
                System.out.println("Eliga una opcion apropiada");
                exit = tecla.nextInt();
            }

            switch (exit){
                case 1:
                    System.out.println();
                    toy1.mostrar();
                    toy2.mostrar();
                    toy3.mostrar();
                    toy4.mostrar();
                    food1.mostrar();
                    food2.mostrar();
                    food3.mostrar();
                    food4.mostrar();
                    System.out.println();

                    System.out.println("Selecciona un producto por su id");
                    int selected = tecla.nextInt();
                    while (selected<101 || selected>108){
                        System.out.println("Selecione un id válido");
                        selected = tecla.nextInt();
                    }
                    for (int i = 0; i < total; i++) {
                        if (listaArticulos[i].getId() == selected){
                            client1.seleccionarProducto(listaArticulos[i]);
                        }
                    }
                    exit = 0;
                    break;
                case 2:
                    System.out.println("Total a cancelar: "+client1.getCesta());
                    System.out.println("Cantidad de productos: "+client1.getCantProductos());
                    if (client1.getCesta()<=client1.getEfectivoEnCuenta()){
                        client1.pagarProductos();
                        System.out.println("Compra realizada con exito");

                    }else System.out.println("Al parecer no tienes el saldo suficiente");

                    System.out.println("Tu saldo es:"+client1.getEfectivoEnCuenta());
                    exit = 0;
                    break;
                case 3:
                    client1.report();
                    exit = 0;
                    break;
                case 4:
                    exit = 1;
                    break;
            }
        }
        System.out.println("Gracias por su compra");
    }
}
