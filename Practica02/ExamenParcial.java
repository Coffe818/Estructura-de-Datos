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
            //JOptionPane.showMessageDialog(null, "Se elimino cliente: " + ElementoBorrado);
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
            this.ElementoBorrado=temp.numcle;
            
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
                InsertarCola(Cola2, ElementoBorrado);
            } else {
                while (!Pila.peek().equals(xelem)) { // mientras que el ultimo elemtento no sea igual a xelem
                    BorrarPila(); // se borrara el elemento y se guarda en ElemtoBorrado
                    InsertarNODO(ElementoBorrado); // se van insertando los ElementoBorrado a la Pila Temp
                } // end while //
                BorrarPila(); // Ya es el elemento que queriamos borrar y lo borramos
                InsertarCola(Cola2, ElementoBorrado);// e inserta en cola
                while (!VaciaNODO()) { // mienras que le PilaTem este vacia
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
        JOptionPane.showMessageDialog(null, "EL tamano de la pila es de: " + Pila.size()
                + "\nEl tamano de Cola1 es de: " + Cola1.size()
                + "\nEl tamano de Cola2 es de: " + Cola2.size());
    }// end Tamabo general

    private void PrimerElementoCola() {
        JOptionPane.showMessageDialog(null, "El primer elemento de la cola es: " + Cola1.getFirst());
    }// end Primer elemento cola

    private void UltimoElementoPila() {
        JOptionPane.showMessageDialog(null, "EL ultimo elemento de la pla es: " + Pila.peek());
    }// end ultimo elemento pila

    private void UltimoElementoCola() {
        JOptionPane.showMessageDialog(null, "El ultimo elemento de la cola es: " + Cola1.getLast());
    }// end ultimo elemento cola

    public static void main(String[] args) {
        ExamenParcial examen = new ExamenParcial();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU LISTA SIMPLE COLAS======"
                    + "\n 1. Insertar Cliente "
                    + "\n 2. Borra Cola1 e Inserta en Pila "
                    + "\n 3. Borrar xelem de Pila "
                    + "\n 4. Borrar un elemento Cola2"
                    + "\n 5. Imprimir Pila "
                    + "\n 6. Imprimir Cola1"
                    + "\n 7. Imprimir Cola2"
                    + "\n 8. Tamano de Pila, Cola1, Cola2"
                    + "\n 9. Imprimir primer elemento de Cola1 "
                    + "\n 10. Imprimir ultimo elemento de Pila "
                    + "\n 11. Imprimir ultimo elemento de Cola1 "
                    + "\n 0. SALIR"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int cliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue el numero de cliente: "));
                    examen.InsertarCola(Cola1, cliente);
                    break;
                case 2:
                    examen.BorrarColaInsertarPila();
                    break;
                case 3:
                    int xclien = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Numero de cliente que quiera borrar: " + Pila));

                    examen.BorrarPilaInsertarCola(xclien);
                    break;
                case 4: 
                    examen.BorrarCola(Cola2);
                    JOptionPane.showMessageDialog(null, "El elimino el primer cliente ");
                case 5:
                    examen.ImprimirPila();
                    break;
                case 6:
                    examen.ImprimirCola(Cola1);
                    break;
                case 7: 
                    examen.ImprimirCola(Cola2);
                    break;
                case 8:
                    examen.TamanoGeneral();
                    break;
                case 9:
                    examen.PrimerElementoCola();
                    break;
                case 10:
                    examen.UltimoElementoPila();
                    break;
                case 11:
                    examen.UltimoElementoCola();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion Valida");
                    break;
            }// end swithc
        } while (opcion != 0);
    }// end main

}// end class
