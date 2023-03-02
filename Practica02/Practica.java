package Practica02;

import java.util.LinkedList;
import java.util.Stack;

public class Practica {
    private Stack<Integer> Pila = new Stack<Integer>();
    private Stack<Integer> PilaTemp = new Stack<Integer>();
    private LinkedList<Integer> Cola1 = new LinkedList<Integer>();
    private LinkedList<Integer> Cola2 = new LinkedList<Integer>();
    private int ElementoBorrado = 0;

    // los metodos vacia reciven una pila o una cola y luego verifica si esta vacia,
    // esto para ahorrar escribir un metodo Vacia(), para cada pila y cada cola
    private boolean VaciaCola(LinkedList<Integer> cola) {
        return cola.isEmpty();
    }// end Vacia Cola

    private boolean VaciaPila(Stack<Integer> pila) {
        return pila.isEmpty();
    }// end Vacia Pila

    // Los metodos insertar tienen la misma logica que Vacia() solo que recibe un
    // elemto para insertarlo
    private void InsertarCola(LinkedList<Integer> cola, int xelem) {
        cola.add(xelem);
    }// end Insertar Cola

    private void InsertarPila(Stack<Integer> pila, int xelem) {
        pila.push(xelem);
    }// end Insertar Pila

    // lso metod insertar piden un linkedlist o un Stack para saber en cual de las
    // dos colas o cual de las dos pilas elimina el elemento y lo guarda en una
    // variable
    private void BorrarCola(LinkedList<Integer> cola) {
        if (!VaciaCola(cola)) {
            this.ElementoBorrado = cola.poll();
            System.out.println("Se elimino cliente: " + ElementoBorrado);
        } else {
            System.out.println("La cola esta vacia");
        } // end if else
    }// end Borrar Cola

    private void BorrarPila(Stack<Integer> pila) {
        if (!VaciaPila(pila)) {
            this.ElementoBorrado = pila.peek();
            pila.pop();
            System.out.println("Elemento eliminado: " + ElementoBorrado);
        } else {
            System.out.println("La pila está vacía");
        } // end if else
    }// end Borrar Pila

    private void BorrarColaInsertarPila() {
        BorrarCola(Cola1);
        InsertarPila(Pila, ElementoBorrado);
    }// end borrar cola e insertar pila

    private void BorrarPilaInsertarCola(int xelem){
        if (!VaciaPila(Pila)) {
            if(Pila.peek().equals(xelem)){
                BorrarPila(Pila);
                InsertarCola(Cola2, xelem);
            }else{
                while (!Pila.peek().equals(xelem)) {            // mientras que el ultimo elemtento no sea igual a xelem
                    BorrarPila(Pila);                           // se borrara el elemento y se guarda en ElemtoBorrado
                    InsertarPila(PilaTemp, ElementoBorrado);    // se van insertando los ElementoBorrado a la Pila Temp
                }//end while                                    //
                BorrarPila(Pila);                               //  Ya es el elemento que queriamos borrar y lo borramos
                while (!VaciaPila(PilaTemp)) {                  // mienras que le PilaTem este vacia 
                    BorrarPila(PilaTemp);                       //  se borra el elemeto y se guarda en ElemtoBorrado
                    InsertarPila(Pila, ElementoBorrado);        // se van insertando los ElementoBorrado a la Pila
                }//end whilw
            }//end ifn else
        } else {
            System.out.println("La pila esta vacia");
        }
    }//end Borrar pila e insertar cola

    private void BorraColaImprimeElemto() {
        BorrarCola(Cola2);
        System.out.println("EL elemto borrado de Cola2 es: "+ ElementoBorrado);
    }

}// end clas
