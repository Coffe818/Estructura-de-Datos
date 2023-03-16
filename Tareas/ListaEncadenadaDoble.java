package Tareas;

import java.time.temporal.Temporal;
import java.util.Scanner;

public class ListaEncadenadaDoble {
    public class Nodo {
        int numArt;
        String nombre;
        int existencia;
        float precio;
        Nodo next;// apuntadores
        Nodo prev;

        public Nodo(int numArt, String nombre, int existencia, float precio) {
            this.numArt = numArt;
            this.nombre = nombre;
            this.existencia = existencia;
            this.precio = precio;
            this.next = null;
        }// end constructor del nodo
    }// end class nodo

    Nodo ant;
    Nodo temp;
    Nodo sig;
    Nodo nuevoNodo;
    Nodo nc;

    public ListaEncadenadaDoble() {
        nuevoNodo = new Nodo(0, "", 0, 0);
        nc = nuevoNodo;
        nc.next = nc;
        nc.prev = nc;
    }

    public boolean Vacia() {
        return nc.next == nc;
    }// end vacia

    public void Insertar(int numArt, String nombre, int existencia, float precio) {
        nuevoNodo = new Nodo(numArt, nombre, existencia, precio);

        temp = nc.next;

        while (temp != nc && temp.numArt <= numArt) {
            temp = temp.next;
        } // end while para recorrer el temp

        ant = temp.prev;
        nuevoNodo.next = temp;
        nuevoNodo.prev = ant;// temp.prev;
        temp.prev = nuevoNodo;
        ant.next = nuevoNodo;
    }// end Insertar

    public void Borrar(int numArt) {
        if (!Vacia()) {
            temp = nc.next;
            while (temp != nc && temp.numArt != numArt) {
                temp = temp.next;
            } // end while que recorre el temp

            ant = temp.prev;
            sig = temp.next;
            ant.next = sig;
            sig.prev = ant;

        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end Borrar

    public void ImprimirNext() {
        temp = nc.next;
        if (!Vacia()) {
            while (temp != nc) {
                System.out.println(
                        "NumArt: " + temp.numArt + "\t Nombre: " + temp.nombre + "\tExistencia: " + temp.existencia
                                + "\tPrecio: " + temp.precio);
                temp = temp.next;
            } // end while que imprime y recorre temp a la derecha
        } else {
            System.out.println("La lista esta vacia");
        }
    }// end Imprimir Next

    public void ImprimirPrev() {
        temp = nc.prev;
        if (!Vacia()) {
            while (temp != nc) {
                System.out.println(
                        "NumArt: " + temp.numArt + "\t Nombre: " + temp.nombre + "\tExistencia: " + temp.existencia
                                + "\tPrecio: " + temp.precio);
                temp = temp.prev;
            } // end while que imprime y recorre temp a la izquierda
        } else {
            System.out.println("La lista esta vacia");
        }
    }// end Imprimir Prev

    public void Tamano() {
        int contador = 0;
        temp = nc.next;
        while (temp != nc) {
            contador++;
            temp = temp.next;
        } // end while
        System.out.println("La cantidad de la lista es de: " + contador);

    }// end tamano

    public void PrecioMayor() {

        Nodo Mayor = nc;
        temp = temp.next;
        while (temp != nc) {

            if (temp.precio > Mayor.precio) {
                Mayor = temp;
            } // si el precio de temporal es mayor al precio mayor que ya tenia el mayor se
              // mueve al temporal

            temp = temp.next;
        } // end while que imprime y recorre temp a la izquierda
        System.out.println("NumArt: " + Mayor.numArt + "\t Nombre: " + Mayor.nombre + "\tExistencia: " + Mayor.existencia
        + "\tPrecio: " + Mayor.precio);
    }// end Precio Mayor

    public static void main(String[] args) {
        ListaEncadenadaDoble lis = new ListaEncadenadaDoble();
        int opcion;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("============Menu Lista Doble=========="
                    + "\n1. Insertar elemento"
                    + "\n2. Eliminar un x Nodo"
                    + "\n3. Imprimir Cantidad de elementos"
                    + "\n4. Imprimir hacia la derecha "
                    + "\n5. Imprimir hacia la izquierda"
                    + "\n6. Imprimir el que tiene precio Mayor"
                    + "\n0. Salir"
                    + "\nSELECCIONE UNA OPCION");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el numero del articulo: ");
                    int numArt = s.nextInt();
                    System.out.println("Ingrese en nombre del articulo: ");
                    String nombre = s.next();
                    System.out.println("Ingrese la existencia de articulo: ");
                    int existencia = s.nextInt();
                    System.out.println("Ingrese el precio del articulo");
                    float precio = s.nextFloat();

                    lis.Insertar(numArt, nombre, existencia, precio);
                    break;
                case 2:
                    System.out.println("Ingrese numero de articulo que desea eliminar: ");
                    numArt = s.nextInt();
                    lis.Borrar(numArt);
                    break;
                case 3:
                    lis.Tamano();
                    break;
                case 4:
                    lis.ImprimirNext();
                    break;
                case 5:
                    lis.ImprimirPrev();
                    break;
                case 6:
                    lis.PrecioMayor();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Ingrece una opcion valida");
                    break;
            }
        } while (opcion != 0);

        s.close();
    }// end main

}// end class
