package Tareas;//tarea 4

import java.util.Scanner;
import java.util.Stack;

public class PilasDinamicas {
    private Stack<Integer> pila = new Stack<Integer>();

    public boolean Vacia() {
        return pila.isEmpty();
    }// end vacia

    public void Insertar(int elemento) {
        pila.push(elemento);
    }// end Insertar

    public void Eliminar() {
        if (!Vacia()) {
            int elemento = pila.peek();
            pila.pop();
            System.out.println("Elemento eliminado: " + elemento);
        } else {
            System.out.println("La pila está vacía");
        } // end if else
    }// end Eliminar

    public void ImprimePila() {
        if (Vacia()) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("Elementos de la pila:");
            System.out.println(pila);
        } // end if else
    }// end Imprime pila

    public void ImprimeUltimo() {
        if (Vacia()) {
            System.out.println("La pila esta vacia");
        } else {
            System.out.println(pila.peek());
        }
    }// end Imprime ultimo o tope de la pila

    public void CantidadElementos() {
        System.out.println(pila.size());

    }// end Cantidad de elementos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilasDinamicas pila = new PilasDinamicas();

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
                    int elemento = scanner.nextInt();
                    pila.Insertar(elemento);
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
            }//end swithc
            System.out.println("-------------------------");
        }// end while

        scanner.close();

    }// end main
}// end class
