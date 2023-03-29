package Tareas;

import java.util.Scanner;
import java.util.Stack;

public class TorresDeHanoi {
    private static Stack<Integer> pila1 = new Stack<Integer>();
    private static Stack<Integer> pila2 = new Stack<Integer>();
    private static Stack<Integer> pila3 = new Stack<Integer>();

    static int origen;
    static int destino;

    public static void MoverDisco(Stack<Integer> pilaOrigen, int destino, int n) {
        Stack<Integer> pilaDestino = null;
        switch (destino) {
            case 1:
                pilaDestino = pila1;
                break;
            case 2:
                pilaDestino = pila2;
                break;
            case 3:
                pilaDestino = pila3;
                break;
            default:
                System.out.println("Pila no válida");
                return;
        }//end switch
        if (!pilaOrigen.empty() && (pilaDestino.empty() || pilaDestino.peek() > pilaOrigen.peek())) {
            int disco = pilaOrigen.pop();
            pilaDestino.push(disco);
            System.out.println("Mover disco " + disco + " de " + origen + " a " + destino);
        } else {
            System.out.println("Movimiento no válido");
        }//end if else
    }// end Mover Disco
    
    

    
}// end class
