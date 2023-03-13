package Practica02;

import java.util.LinkedList;
import javax.swing.JOptionPane;
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
        if (VaciaNODO()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.next = nuevoNodo;
            fin = nuevoNodo;
        } // end if else
    }// end insertar

    // METODOS PARA BORRAR
    private void BorrarCola() {
        if (!VaciaCola()) {
            this.ElementoBorrado = Cola.poll();
            //JOptionPane.showMessageDialog(null,"Se elimino cliente: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null,"La cola esta vacia");
        } // end if else
    }// end Borrar Cola

    private void BorrarPila() {
        if (!VaciaPila()) {
            this.ElementoBorrado = Pila.pop();
            //JOptionPane.showMessageDialog(null, "Elemento eliminado: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        } // end if else
    }// end Borrar Pila

    public void BorrarNODO() {
        if (!VaciaNODO()) {
            temp = inicio;
            inicio = inicio.next;
            if (inicio == null) {
                fin = null;
            } // significa que ahora esta vacia
            this.ElementoBorrado=temp.numcle;
            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end borrar

    // METODOS QUE BORRAN DE UN LADO Y LO PASAN A OTRO LADO
    public void InsertarPilaBorrarCola() {
        Pila.push(Cola.poll());
    }// end Borrr cola e insertar pila

    private void BorrarColaInsertarPila() {
        BorrarCola();
        JOptionPane.showMessageDialog(null, "Se borro el elemento " + ElementoBorrado + " y se agrego a Pila");
        InsertarPila(ElementoBorrado);
    }// end borrar cola e insertar pila

    private void BorrarPilaInsertarCola(int xelem) {
        if (!VaciaPila()) {
            if (Pila.peek().equals(xelem)) {
                BorrarPila();
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
            JOptionPane.showMessageDialog(null, "Se elimino de Pila el cliente: " + ElementoBorrado);
        } else {
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
        } // end if else
    }// end Borrar pila e insertar cola

    // METODOS PARA IMPRIMIR
    private void ImprimirPila() {
        if (!VaciaPila()) {
            JOptionPane.showMessageDialog(null, "Elementos de la pila: " + Pila);
        } else {
            JOptionPane.showMessageDialog(null, "La Pila esta vacia");
        } // end if else
    }// end imprimir pila

    private void ImprimirCola() {
        if (!VaciaCola()) {
            JOptionPane.showMessageDialog(null, "Elementos de la cola: " + Cola);
        } else {
            JOptionPane.showMessageDialog(null, "La Cola esta vacia");
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
        JOptionPane.showMessageDialog(null, "EL tamano de la pila es de: " + Pila.size()
                + "\nEl tamano de Cola es de: " + Cola.size()
                + "\nEl tamano de Cola tipo NODO es de: " + TamanoNODO());
    }// end Tamano general

    private void PrimerElementoCola() {
        JOptionPane.showMessageDialog(null, "El primer elemento de la cola es: " + Cola.getFirst());
    }// end Primer elemento cola

    private void UltimoElementoCola() {
        JOptionPane.showMessageDialog(null, "El ultimo elemento de la cola es: " + Cola.getLast());
    }// end ultimo elemento cola

    private void UltimoElementoPila() {
        JOptionPane.showMessageDialog(null, "EL ultimo elemento de la pla es: " + Pila.peek());
    }// end ultimo elemento pila

    public static void main(String[] args) {
        ExamenParcial1 practica2 = new ExamenParcial1();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU LISTA SIMPLE COLAS======"
                    + "\n 1. Insertar Cliente "
                    + "\n 2. Borra Cola e Inserta en Pila "
                    + "\n 3. Borrar xelem de Pila "
                    + "\n 4. Imprimir Pila "
                    + "\n 5. Imprimir Cola1"
                    + "\n 6. Tamano de Pila, Cola, ColaNODO"
                    + "\n 7. Imprimir primer elemento de Cola "
                    + "\n 8. Imprimir ultimo elemento de Pila "
                    + "\n 9. Imprimir ultimo elemento de Cola "
                    + "\n 0. SALIR"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int cliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Agregue el numero de cliente: "));
                    practica2.InsertarCola(cliente);
                    break;
                case 2:
                    practica2.BorrarColaInsertarPila();
                    break;
                case 3:
                    int xclien = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de cliente que quiera borrar: "+Pila));

                    practica2.BorrarPilaInsertarCola(xclien);
                    break;
                case 4:
                    practica2.ImprimirPila();
                    break;
                case 5:
                    practica2.ImprimirCola();
                    break;
                case 6:
                    practica2.TamanoGeneral();
                    break;
                case 7:
                    practica2.PrimerElementoCola();
                    break;
                case 8:
                    practica2.UltimoElementoPila();
                    break;
                case 9:
                    practica2.UltimoElementoCola();
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
