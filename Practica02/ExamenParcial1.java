package Practica02;

import java.util.LinkedList;
import java.util.Stack;

public class ExamenParcial1 {
    private static Stack<Integer> Pila = new Stack<Integer>();
    private static LinkedList<Integer> Cola = new LinkedList<Integer>();
    private int ElementoBorrado = 0;

    public class Nodo {
        int numcle;
        Nodo next;
        public Nodo(int numcle) {
            this.numcle = numcle;
            this.next = null;
        }// end constructor del nodo
    }// end class nodo

    Nodo inicio;
    Nodo fin;
    Nodo temp;
    Nodo ant;

    private boolean VaciaCola() {
        return Cola.isEmpty();
    }// end Vacia Cola

    private boolean VaciaPila() { 
        return Pila.isEmpty();
    }// end Vacia Pila

    private void InsertarCola(int xelem) {
        Cola.add(xelem);
    }// end Insertar Cola

    private void InsertarPila(int xelem) {
        Pila.push(xelem);
    }// end Insertar Pila

    private void BorrarCola() {
        if (!VaciaCola()) {
            this.ElementoBorrado = Cola.poll();
            System.out.println("Se elimino cliente: " + ElementoBorrado);
        } else {
            System.out.println("La cola esta vacia");
        } // end if else
    }// end Borrar Cola

    private void BorrarPila() {
        if (!VaciaPila()) {
            this.ElementoBorrado = Pila.peek();
            Pila.pop();
            System.out.println("Elemento eliminado: " + ElementoBorrado);
        } else {
            System.out.println("La pila está vacía");
        } // end if else
    }// end Borrar Pila


    public void InsertarPilaBorrarCola() {
        Pila.push(Cola.poll());
    }//end Borrr cola e insertar pila

    private void BorrarColaInsertarPila() {
        BorrarCola();
        System.out.println("Se borro el elemento " + ElementoBorrado + " y se agrego a Pila");
        InsertarPila( ElementoBorrado);
    }// end borrar cola e insertar pila




}//end class
