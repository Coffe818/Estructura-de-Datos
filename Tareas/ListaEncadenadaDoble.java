package Tareas;

import java.time.temporal.Temporal;

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

    public ListaEncadenadaDoble(){
        nuevoNodo = new Nodo(0, "", 0, 0);
        nc = nuevoNodo;
        nc.next=nc;
        nc.prev=nc;
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
        }//end if else
    }// end Borrar

    public void ImprimirNext(){
        temp=nc.next;
        if (!Vacia()) {
            while(temp!=nc ){
                System.out.println("NumArt: " + temp.numArt + "\t Nombre: " + temp.nombre + "\tExistencia: " + temp.existencia
                + "\tPrecio: " + temp.precio);
                temp=temp.next;
            }//end while que imprime y recorre temp a la derecha
        }else{
            System.out.println("La lista esta vacia");
        }
    }//end Imprimir Next

    public void ImprimirPrev(){
        temp=nc.prev;
        if (!Vacia()) {
            while(temp!=nc ){
                System.out.println("NumArt: " + temp.numArt + "\t Nombre: " + temp.nombre + "\tExistencia: " + temp.existencia
                + "\tPrecio: " + temp.precio);
                temp=temp.prev;
            }//end while que imprime y recorre temp a la izquierda  
        }else{
            System.out.println("La lista esta vacia");
        }
    }//end Imprimir Prev

}// end class
