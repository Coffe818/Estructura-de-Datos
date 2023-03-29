package Tareas;

import java.util.Scanner;
import java.util.Stack;

public class TorresDeHanoi {
    private static Stack<Integer> pila1 = new Stack<Integer>();
    private static Stack<Integer> pila2 = new Stack<Integer>();
    private static Stack<Integer> pila3 = new Stack<Integer>();

    static int origen;
    static int destino;

    public static void MoverDisco(Stack<Integer> pilaOrigen, int destino) {
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
            int DiscoEliminado = pilaOrigen.pop();
            pilaDestino.push(DiscoEliminado);
            System.out.println("Mover disco " + DiscoEliminado + " de pila " + origen + " a pila " + destino);
        } else {
            System.out.println("Movimiento no válido");
        }//end if else
    }// end Mover Disco
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de discos: ");
        int CantidadElementos = sc.nextInt();

        for (int i = CantidadElementos; i >= 1; i--) {
            pila1.push(i);
        }//end for para llena la pila 1

        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            System.out.println("Pila 1: " + pila1.toString());
            System.out.println("Pila 2: " + pila2.toString());
            System.out.println("Pila 3: " + pila3.toString());

            System.out.print("Ingrese la pila de origen (1, 2, 3): ");
            origen = sc.nextInt();
            System.out.print("Ingrese la pila de destino (1, 2, 3): ");
            destino = sc.nextInt();

            switch (origen) {
                case 1:
                    MoverDisco(pila1, destino);
                    break;
                case 2:
                    MoverDisco(pila2, destino);
                    break;
                case 3:
                    MoverDisco(pila3, destino);
                    break;
                default:
                    System.out.println("Pila no válida");
                    break;
            }// end swithc

            if (pila3.size() == CantidadElementos) {
                System.out.println("¡Juego terminado!");
                juegoTerminado = true;
            }//end if 
        }//end while
        sc.close();
    }//end main
}// end class
