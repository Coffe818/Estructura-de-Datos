package Practica02;

import java.util.LinkedList;
import java.util.Stack;

public class Practica {
    private Stack<Integer> Pila = new Stack<Integer>();
    private Stack<Integer> PilaTemp = new Stack<Integer>();
    static LinkedList <Integer> Cola1 = new LinkedList<Integer>();
    static LinkedList <Integer> Cola2 = new LinkedList<Integer>();
    
    private boolean VaciaCola(LinkedList<Integer> cola) {
        return cola.isEmpty();
    }// 
    private boolean VaciaPila(Stack<Integer> pila) {
        return pila.isEmpty();
    }
    

}// end clas
