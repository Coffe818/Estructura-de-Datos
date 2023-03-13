package Practica02;

import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class ExamenParcial {
    private static Stack<Integer> Pila = new Stack<Integer>();
    private static LinkedList<Integer> Cola1 = new LinkedList<Integer>();
    private static LinkedList<Integer> Cola2 = new LinkedList<Integer>();
    int ElementoBorrado=0;
    
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

    //METODO VACIA
    private boolean VaciaPila() {
        return Pila.isEmpty();
    }// end Vacia Pila

    private boolean VaciaCola(LinkedList<Integer> cola) {
        return cola.isEmpty();
    }// end Vacia Cola

    public boolean VaciaNODO() {
        return top == null;
    }// end vacia

    //METODOS PARA INSERTAR
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

    //METODOS PARA BORRAR
    private void BorrarPila() {
        if (!VaciaPila()) {
            this.ElementoBorrado = Pila.pop();
            //JOptionPane.showMessageDialog(null, "Elemento eliminado: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        } // end if else
    }// end Borrar Pila

    private void BorrarCola(LinkedList<Integer> cola) {
        if (!VaciaCola(cola)) {
            this.ElementoBorrado = cola.poll();
            JOptionPane.showMessageDialog(null,"Se elimino cliente: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null,"La cola esta vacia");
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

            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + temp.numcle);
            cantidad--;
        } else {
            JOptionPane.showMessageDialog(null, "Esta vacia la lista");
        } // if else
    }// end Borrar

}// end class
