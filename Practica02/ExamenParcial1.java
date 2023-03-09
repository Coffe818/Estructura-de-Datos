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
    Nodo nuevoNodo;

    // METODOS VACIA
    private boolean VaciaCola() {
        return Cola.isEmpty();
    }// end Vacia Cola

    private boolean VaciaPila() {
        return Pila.isEmpty();
    }// end Vacia Pila

    public boolean VaciaNODO() {
        return inicio == null;
    }// end vacia

    // METODOS PARA INSERTAR
    private void InsertarCola(int xelem) {
        Cola.add(xelem);
    }// end Insertar Cola

    private void InsertarPila(int xelem) {
        Pila.push(xelem);
    }// end Insertar Pila

    public void InsertarNODO(int numcle) {
        nuevoNodo = new Nodo(numcle);
        if (!VaciaNODO()) {
            fin.next = nuevoNodo;
            fin = nuevoNodo;
        } else {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } // end if else
    }// end insertar

    // METODOS PARA BORRAR
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

    public void BorrarNODO() {
        if (!VaciaNODO()) {
            temp = inicio;
            inicio = inicio.next;
            if (inicio == null) {
                fin = null;
            } // significa que ahora esta vacia
            System.out.println("Se ha borrado el empleado numero: " + temp.numcle);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end borrar

    // METODOS QUE BORRAN DE UN LADO Y LO PASAN A OTRO LADO
    public void InsertarPilaBorrarCola() {
        Pila.push(Cola.poll());
    }// end Borrr cola e insertar pila

    private void BorrarColaInsertarPila() {
        BorrarCola();
        System.out.println("Se borro el elemento " + ElementoBorrado + " y se agrego a Pila");
        InsertarPila(ElementoBorrado);
    }// end borrar cola e insertar pila

    private void BorrarPilaInsertarCola(int xelem) {
        if (!VaciaPila()) {
            if (Pila.peek().equals(xelem)) {
                BorrarPila();
                InsertarNODO(xelem);
            } else {
                while (!Pila.peek().equals(xelem)) { // mientras que el ultimo elemtento no sea igual a xelem
                    BorrarPila(); // se borrara el elemento y se guarda en ElemtoBorrado
                    InsertarNODO(ElementoBorrado); // se van insertando los ElementoBorrado al NODO
                } // end while 
                BorrarPila(); // Ya es el elemento que queriamos borrar y lo borramos

                while (!VaciaNODO()) { // mienras que el NODO no este vacia
                    BorrarNODO(); // se borra el elemeto y se guarda en ElemtoBorrado
                    InsertarPila(ElementoBorrado); // se van insertando los ElementoBorrado a la Pila
                } // end whilw
            } // end ifn else
            System.out.println("Se elimino de Pila y se agrego a Cola2 el cliente: " + ElementoBorrado);
        } else {
            System.out.println("La pila esta vacia");
        } // end if else
    }// end Borrar pila e insertar cola

    // METODOS PARA IMPRIMIR
    private void ImprimirPila() {
        if (!VaciaPila()) {
            System.out.println("Elementos de la pila: " + Pila);
        } else {
            System.out.println("La Pila esta vacia");
        } // end if else
    }// end imprimir pila

    private void ImprimirCola() {
        if (!VaciaCola()) {
            System.out.println("Elementos de la cola: " + Cola);
        } else {
            System.out.println("La Cola esta vacia");
        } // end if else
    }// end imprimir cola

    public int TamanoNODO() {
        int contador = 0;
        if (!VaciaNODO()) {
            temp = inicio;
            while (temp != null) {
                contador++;
                temp = temp.next;
            } // end while
        } // end if
        return contador;
    }// end Tamano

    private void TamanoGeneral() {
        System.out.println("EL tamano de la pila es de: " + Pila.size()
                + "\nEl tamano de Cola es de: " + Cola.size()
                + "\nEl tamano de Cola tipo NODO es de: " + TamanoNODO());
    }// end Tamano general

    private void PrimerElementoCola() {
        System.out.println("El primer elemento de la cola es: " + Cola.getFirst());
    }// end Primer elemento cola

    private void UltimoElementoCola() {
        System.out.println("El ultimo elemento de la cola es: " + Cola.getLast());
    }// end ultimo elemento cola

    private void UltimoElementoPila() {
        System.out.println("EL ultimo elemento de la pla es: " + Pila.peek());
    }// end ultimo elemento pila


}// end class
