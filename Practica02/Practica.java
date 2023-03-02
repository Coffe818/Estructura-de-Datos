package Practica02;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Practica {
    private static Stack<Integer> Pila = new Stack<Integer>();
    private static Stack<Integer> PilaTemp = new Stack<Integer>();
    private static LinkedList<Integer> Cola1 = new LinkedList<Integer>();
    private static LinkedList<Integer> Cola2 = new LinkedList<Integer>();
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
        System.out.println("Se borro el elemento " + ElementoBorrado + " y se agrego a Pila");
        InsertarPila(Pila, ElementoBorrado);
    }// end borrar cola e insertar pila

    private void BorrarPilaInsertarCola(int xelem) {
        if (!VaciaPila(Pila)) {
            if (Pila.peek().equals(xelem)) {
                BorrarPila(Pila);
                InsertarCola(Cola2, xelem);
            } else {
                while (!Pila.peek().equals(xelem)) { // mientras que el ultimo elemtento no sea igual a xelem
                    BorrarPila(Pila); // se borrara el elemento y se guarda en ElemtoBorrado
                    InsertarPila(PilaTemp, ElementoBorrado); // se van insertando los ElementoBorrado a la Pila Temp
                } // end while //
                BorrarPila(Pila); // Ya es el elemento que queriamos borrar y lo borramos
                while (!VaciaPila(PilaTemp)) { // mienras que le PilaTem este vacia
                    BorrarPila(PilaTemp); // se borra el elemeto y se guarda en ElemtoBorrado
                    InsertarPila(Pila, ElementoBorrado); // se van insertando los ElementoBorrado a la Pila
                } // end whilw
            } // end ifn else
            System.out.println("Se elimino de Pila y se agrego a Cola2 el cliente: " + ElementoBorrado);
        } else {
            System.out.println("La pila esta vacia");
        }
    }// end Borrar pila e insertar cola

    private void BorraColaImprimeElemto() {
        BorrarCola(Cola2);
        System.out.println("EL elemto borrado de Cola2 es: " + ElementoBorrado);
    }// end borrar cola imprimmir elemento

    private void ImprimirPila() {
        if (!VaciaPila(Pila)) {
            System.out.println("Elementos de la pila: " + Pila);
        } else {
            System.out.println("La Pila esta vacia");
        } // end if else
    }// end imprimir pila

    private void ImprimirCola(LinkedList<Integer> cola) {
        if (!VaciaCola(cola)) {
            System.out.println("Elementos de la pila: " + cola);
        } else {
            System.out.println("La Cola esta vacia");
        } // end if else
    }// end imprimir cola

    private void TamanoGeneral() {
        System.out.println("EL tamano de la pila es de: " + Pila.size()
                + "\nEl tamano de Cola1 es de: " + Cola1.size()
                + "\nEl tamano de Cola2 es de: " + Cola2.size());
    }// end Tamabo general

    private void PrimerElementoCola(LinkedList<Integer> cola) {
        System.out.println("El primer elemento de la cola es: " + cola.getFirst());
    }// end Primer elemento cola

    private void UltimoElementoCola(LinkedList<Integer> cola) {
        System.out.println("El ultimo elemento de la cola es: " + cola.getLast());
    }// end ultimo elemento cola

    private void UltimoElementoPila() {
        System.out.println("EL ultimo elemento de la pla es: " + Pila.peek());
    }// end ultimo elemento pila

    public static void main(String[] args) {
        Practica practica = new Practica();
        int opcion;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("=========== Menu Practica =========="
                    + "\n 1. Insertar Cliente "
                    + "\n 2. Borra Cola 1 e Inserta en Pila "
                    + "\n 3. Borrar xelem de Pila e insertarlo en Cola2 "
                    + "\n 4. Borrar Cola 2 e imprimir "
                    + "\n 5. Imprimir Pila "
                    + "\n 6. Imprimir Cola1 "
                    + "\n 7. Imprimir Cola2 "
                    + "\n 8. Tamano de Pila, Cola1, Cola2 "
                    + "\n 9. Imprimir primer elemento de Cola1 "
                    + "\n 10. Imprimir primer elemento de Cola2 "
                    + "\n 11. Imprimir ultimo elemento de Pila "
                    + "\n 12. Imprimir ultimo elemento de Cola1 ");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Agregue el numero de cliente: ");
                    int cliente = s.nextInt();
                    practica.InsertarCola(Cola1, cliente);
                    break;
                case 2:
                    practica.BorrarColaInsertarPila();
                    break;
                case 3:
                    System.out.println("Numero de cliente que quiera borrar: ");
                    practica.ImprimirPila();
                    int xclien = s.nextInt();
                    practica.BorrarPilaInsertarCola(xclien);
                    break;
                case 4:
                    practica.BorraColaImprimeElemto();
                    break;
                case 5:
                    practica.ImprimirPila();
                    break;
                case 6:
                    practica.ImprimirCola(Cola1);
                    break;
                case 7:
                    practica.ImprimirCola(Cola2);
                    break;
                case 8:
                    practica.TamanoGeneral();
                    break;
                case 9:
                    practica.PrimerElementoCola(Cola1);
                    break;
                case 10:
                    practica.PrimerElementoCola(Cola2);
                    break;
                case 11:
                    practica.UltimoElementoPila();
                    break;
                case 12:
                    practica.UltimoElementoCola(Cola1);
                    break;
                default:
                    System.out.println("Ingrese una opcion Valida");
                    break;
            }// end swithc
        } while (opcion != 0);
        s.close();
    }// end main
}// end clas
