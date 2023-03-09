package Practica02;

import java.util.LinkedList;
import java.util.Stack;

public class ExamenParcial1 {
    private static Stack<Integer> Pila = new Stack<Integer>();
    private static LinkedList<Integer> Cola1 = new LinkedList<Integer>();

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
    
}//end class
