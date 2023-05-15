package Tareas;

import java.util.Scanner;
import java.util.Stack;

public class Laberinto {
    private int[][] laberinto;
    private int filas;
    private int columnas;
    private static Stack<Integer> pila = new Stack<Integer>();

    public Laberinto() {
        this.filas = 8;
        this.columnas = 8;
        this.laberinto = new int[filas + 2][columnas + 2];

    }// end contructor de Laberinto

    public void crearLaberinto() {
        // le pongo valor a 1 al camino del laberinto
        laberinto[1][1] = 1;
        laberinto[1][2] = 1;
        laberinto[2][2] = 1;
        laberinto[3][2] = 1;
        laberinto[3][3] = 1;
        laberinto[3][4] = 1;
        laberinto[4][4] = 1;
        laberinto[5][4] = 1;
        laberinto[5][5] = 1;
        laberinto[6][5] = 1;
        laberinto[6][6] = 1;
        laberinto[7][6] = 1;
        laberinto[7][7] = 1;
        laberinto[8][7] = 1;
        laberinto[8][8] = 1;

        // Rellenar los bordes del laberinto con ceros
        for (int i = 0; i < columnas + 2; i++) {
            laberinto[0][i] = 0;
            laberinto[filas + 1][i] = 0;
        }
        for (int i = 0; i < filas + 2; i++) {
            laberinto[i][0] = 0;
            laberinto[i][columnas + 1] = 0;
        }
    }//end crearLaberinto

    public void mostrarLaberinto() {

        for (int i = 0; i < filas + 2; i++) {
            for (int j = 0; j < columnas + 2; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println();
        } // end for para imprimir el laberinto
    }// end mostrarLaberinto

    public void resolverLaberinto() {
        int[][] movimientos = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // Derecha, Abajo, Izquierda, Arriba
        int filaActual = 1;
        int columnaActual = 1;
        int movimientoActual = 0;

        while (filaActual != filas || columnaActual != columnas) {// se repite hasta la salida del laberinto
            int siguienteFila = filaActual + movimientos[movimientoActual][0];
            int siguienteColumna = columnaActual + movimientos[movimientoActual][1];

            if (laberinto[siguienteFila][siguienteColumna] == 1) {
                // se guarda la posicion
                pila.push(filaActual);
                pila.push(columnaActual);

                // se marca como 2 en el laberinto para saber que es correcto
                laberinto[filaActual][columnaActual] = 2;

                // se recorre al siguiente movimiento
                filaActual = siguienteFila;
                columnaActual = siguienteColumna;
                movimientoActual = 0;
            } else {
                movimientoActual = (movimientoActual + 1) % 4;
                if (movimientoActual == 0) {
                     // Marcamos como camino recorrido incorrecto
                    laberinto[filaActual][columnaActual] = 5;

                    if (!pila.isEmpty()) {
                        columnaActual = pila.pop();
                        filaActual = pila.pop();
                    }
                } // end if para saber que este camino ya no tiene salida
            } // end if else para saber si el camino es correcto "1"
        } // end while

        // Marcar la posición de salida como camino recorrido correcto
        laberinto[filas][columnas] = 2;
    }//end resolverLaberinto

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Laberinto laberinto = new Laberinto();
        laberinto.crearLaberinto();

        System.out.println("Laberinto:");
        laberinto.mostrarLaberinto();
        System.out.println("Elementos de la pila:");
        laberinto.resolverLaberinto();
        System.out.println(pila);

        s.close();
    }// end main
}// end class