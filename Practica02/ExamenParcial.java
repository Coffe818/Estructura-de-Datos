package Practica02;

import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class ExamenParcial {
    private static Stack<Integer> Pila = new Stack<Integer>();
    private static LinkedList<Integer> Cola1 = new LinkedList<Integer>();
    private static LinkedList<Integer> Cola2 = new LinkedList<Integer>();
    int ElementoBorrado = 0;

    public class Nodo {
        int numcle;
        Nodo next;

        public Nodo(int numcle) {
            this.numcle = numcle;
            this.next = null;
        }// end constructor del nodo
    }// end class nodo

    Nodo top;
    Nodo temp;
    Nodo ant;
    Nodo nuevoNodo;
    int cantidad;

    // METODO VACIA
    private boolean VaciaPila() {
        return Pila.isEmpty();
    }// end Vacia Pila

    private boolean VaciaCola(LinkedList<Integer> cola) {
        return cola.isEmpty();
    }// end Vacia Cola

    public boolean VaciaNODO() {
        return top == null;
    }// end vacia

    // METODOS PARA INSERTAR
    private void InsertarPila(int xelem) {
        Pila.push(xelem);
    }// end Insertar Pila

    private void InsertarCola(LinkedList<Integer> cola, int xelem) {
        cola.add(xelem);
    }// end Insertar Cola

    public void InsertarNODO(int numcle) {
        nuevoNodo = new Nodo(numcle);
        if (VaciaNODO()) {
            top = nuevoNodo;
        } else {
            temp = top;
            while (temp.next != null) {
                temp = temp.next;
            } // end while
            temp.next = nuevoNodo;
        } // end fi else recorre el top hasta el final y ahi agrega el nodod
        cantidad++;
    }// end Insertar elemento

    // METODOS PARA BORRAR
    private void BorrarPila() {
        if (!VaciaPila()) {
            this.ElementoBorrado = Pila.pop();
            // JOptionPane.showMessageDialog(null, "Elemento eliminado: " +
            // ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        } // end if else
    }// end Borrar Pila

    private void BorrarCola(LinkedList<Integer> cola) {
        if (!VaciaCola(cola)) {
            this.ElementoBorrado = cola.poll();
            JOptionPane.showMessageDialog(null, "Se elimino cliente: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } // end if else
    }// end Borrar Cola

    public void BorrarNODO() {
        if (!VaciaNODO()) {
            temp = top;
            ant = null;

            while (temp.next != null) {
                ant = temp;
                temp = temp.next;
            } // recorre ant y temp hasta el final

            if (ant == null) {
                top = null;
            } else {
                ant.next = null;
            } // borra dependiendo de si es el primero y deja la cola vacia o sino y borra el
              // ultimo
            ElementoBorrado = temp.numcle;
            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + ElementoBorrado);
            cantidad--;
        } else {
            JOptionPane.showMessageDialog(null, "Esta vacia la lista");
        } // if else
    }// end Borrar

    // METODOS PARA BORRAR DE UN LADO E INSERTAR EL OTRO LADO
    private void BorrarColaInsertarPila() {
        BorrarCola(Cola1);
        JOptionPane.showMessageDialog(null, "Se borro el elemento " + ElementoBorrado + " y se agrego a Pila");
        InsertarPila(ElementoBorrado);
    }// end borrar cola e insertar pila

    private void BorrarPilaInsertarCola(int xelem) {
        if (!VaciaPila()) {
            if (Pila.peek().equals(xelem)) {
                BorrarPila();
                InsertarCola(Cola2, xelem);
            } else {
                while (!Pila.peek().equals(xelem)) { // mientras que el ultimo elemtento no sea igual a xelem
                    BorrarPila(); // se borrara el elemento y se guarda en ElemtoBorrado
                    InsertarNODO(ElementoBorrado); // se van insertando los ElementoBorrado a la Pila Temp
                } // end while //
                BorrarPila(); // Ya es el elemento que queriamos borrar y lo borramos
                InsertarCola(Cola2, ElementoBorrado);// e inserta en cola
                while (!VaciaPila()) { // mienras que le PilaTem este vacia
                    BorrarNODO(); // se borra el elemeto y se guarda en ElemtoBorrado
                    InsertarPila(ElementoBorrado); // se van insertando los ElementoBorrado a la Pila
                } // end whilw
            } // end ifn else
            JOptionPane.showMessageDialog(null,
                    "Se elimino de Pila y se agrego a Cola2 el cliente: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
        } // end if else
    }// end Borrar pila e insertar cola

    // METODO PARA IMPRIMIR
    private void ImprimirPila() {
        if (!VaciaPila()) {
            JOptionPane.showMessageDialog(null, "Elementos de la pila: " + Pila);
        } else {
            JOptionPane.showMessageDialog(null, "La Pila esta vacia");
        } // end if else
    }// end imprimir pila

    private void ImprimirCola(LinkedList<Integer> cola) {
        if (!VaciaCola(cola)) {
            JOptionPane.showMessageDialog(null, "Elementos de la cola: " + cola);
        } else {
            JOptionPane.showMessageDialog(null, "La Cola esta vacia");
        } // end if else
    }// end imprimir cola

    private void TamanoGeneral() {
        JOptionPane.showMessageDialog(null,"EL tamano de la pila es de: " + Pila.size()
                + "\nEl tamano de Cola1 es de: " + Cola1.size()
                + "\nEl tamano de Cola2 es de: " + Cola2.size());
    }// end Tamabo general

    private void PrimerElementoCola(    ) {
        JOptionPane.showMessageDialog(null,"El primer elemento de la cola es: " + Cola1.getFirst());
    }// end Primer elemento cola
    
    private void UltimoElementoPila() {
        JOptionPane.showMessageDialog(null,"EL ultimo elemento de la pla es: " + Pila.peek());
    }// end ultimo elemento pila

    private void UltimoElementoCola() {
        JOptionPane.showMessageDialog(null,"El ultimo elemento de la cola es: " + Cola1.getLast());
    }// end ultimo elemento cola

    

}// end class
