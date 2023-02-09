package Tareas;//tarea 3

import java.util.Scanner;

public class PilasEstatica {
    int tamano = 50;
    int top = -1;
    int pila[]= new int [tamano];

    public boolean Vacia() {
        return top == -1;
    }// end vacia

    public boolean Llena() {
        return top == tamano - 1;
    }// end llena

    public void Insertar(int elemento) {// push
        if (Llena()) {
            System.out.println("La pila está llena");
        } else {
            top++;
            pila[top] = elemento;
            System.out.println("Elemento agregado: " + elemento);
        }
    }// end Insertar

    public int Eliminar() {// pop
        if (Vacia()) {
            System.out.println("La pila está vacía");
            return -1;
        } else {
            int elemento = pila[top];
            top--;
            System.out.println("Elemento eliminado: " + elemento);
            return elemento;
        }
    }// end eliminar

    public void ImprimePila() {
        if (Vacia()) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("Elementos de la pila:");
            for (int i = top; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }// end impriir pila

    public void ImprimeUltimo() {
        System.out.println(pila[top]);
    }// end imprime ultimo

    public int CantidadElementos() {
        return top + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilasEstatica pila = new PilasEstatica();

        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Ver elementos de la pila");
            System.out.println("4. Imprimr el ultimo elemento");
            System.out.println("5. Cantidad de elementos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa un elemento: ");
                    int x = scanner.nextInt();
                    pila.Insertar(x);
                    break;
                case 2:
                    pila.Eliminar();
                    break;
                case 3:
                    pila.ImprimePila();
                    break;
                case 4:
                    pila.ImprimeUltimo();
                    break;
                case 5:
                    pila.CantidadElementos();
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }//end switch
            System.out.println("-------------------------");
        }//end while

        scanner.close();

    }// end main

}// end class
