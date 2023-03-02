package Practica02;

import java.util.LinkedList;
import java.util.Stack;

public class Practica {
    private Stack<Integer> Pila = new Stack<Integer>();
    private Stack<Integer> PilaTemp = new Stack<Integer>();
    private LinkedList<Integer> Cola1 = new LinkedList<Integer>();
    private LinkedList<Integer> Cola2 = new LinkedList<Integer>();

    // los metodos vacia reciven una pila o una cola y luego verifica si esta vacia,
    // esto para ahorrar escribir un metodo Vacia(), para cada pila y cada cola
    private boolean VaciaCola(LinkedList<Integer> cola) {
        return cola.isEmpty();
    }// end Vacia Cola

    private boolean VaciaPila(Stack<Integer> pila) {
        return pila.isEmpty();
    }// end Vacia Pila

    //Los metodos insertar tienen la misma logica que Vacia() solo que recibe un elemto para insertarlo
    private void InsertarCola(LinkedList<Integer> cola, int elemento) {
        cola.add(elemento);
    }// end Insertar Cola
    private void InsertarPila(Stack<Integer> pila, int elemento){
        pila.push(elemento);
    }// end Insertar Pila

    //lso metod insertar piden un linkedlist o un Stack para saber en cual de las dos colas o cual de las dos pilas elimina el elemento
    private void BorrarCola(LinkedList<Integer> cola) {
        if (!VaciaCola(cola)) {
            int elemento = cola.poll();
            System.out.println("Se elimino cliente: "+ elemento);
        } else {
            System.out.println("La cola esta vacia");
        }//end if else
    }// end Borrar Cola
    private void BorrarPila(Stack<Integer> pila) {
        if (!VaciaPila(pila)) {
            int elemento = pila.peek();
            pila.pop();
            System.out.println("Elemento eliminado: " + elemento);
        } else {
            System.out.println("La pila está vacía");
        } // end if else
    }//end Borrar Pila

}// end clas
