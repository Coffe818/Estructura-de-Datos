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

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de discos: ");
        int n = sc.nextInt();

        for (int i = n; i >= 1; i--) {
            pila1.push(i);
        }
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            System.out.println("Pila A: " + pila1.toString());
            System.out.println("Pila B: " + pila2.toString());
            System.out.println("Pila C: " + pila3.toString());
            System.out.print("Ingrese la pila de origen (1, 2, 3): ");
            origen = sc.next().charAt(0);
            System.out.print("Ingrese la pila de destino (1, 2, 3): ");
            destino = sc.next().charAt(0);
            switch (origen) {
                case 1:
                    MoverDisco(pila1, destino, n);
                    break;
                case 2:
                    MoverDisco(pila2, destino, n);
                    break;
                case 3:
                    MoverDisco(pila3, destino, n);
                    break;
                default:
                    System.out.println("Pila no válida");
                    break;
            }
            if (pila3.size() == n) {
                System.out.println("¡Juego terminado!");
                juegoTerminado = true;
            }
        }
        sc.close();
    }

    
}// end class
