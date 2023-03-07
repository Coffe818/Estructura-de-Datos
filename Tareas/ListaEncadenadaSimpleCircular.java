package Tareas;

import java.time.temporal.Temporal;
import java.util.Scanner;

public class ListaEncadenadaSimpleCircular {

    public class Nodo {
        int numEmp;
        String nombre;
        int depto;
        float sueldo;
        Nodo next;

        public Nodo(int numEmp, String nombre, int depto, float sueldo) {
            this.numEmp = numEmp;
            this.nombre = nombre;
            this.depto = depto;
            this.sueldo = sueldo;
            this.next = null;
        }// end constructor del nodo
    }// end class nodo

    Nodo ant;
    Nodo temp;
    Nodo nuevoNodo;
    Nodo nc;

    public ListaEncadenadaSimpleCircular() {
        nuevoNodo = new Nodo(0, "", 0, 0);
        nc = nuevoNodo;
        nc.next=nc;
        temp=nc;
    }// end contstructor

    public boolean Vacia() {
        return nc.next == nc;
    }// end Vacia

    public void Insertar(int numEmp, String nombre, int depto, float sueldo) {
        nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
        /*if (Vacia()) {
            nc.next = nuevoNodo;
            nuevoNodo.next = nc;
        } else {*/
            temp = nc.next;
            ant = nc;
            while (temp != nc && temp.depto <= depto && temp.numEmp < numEmp) {// Recore ant y temp
                                                                               // hasta que se acomode
                                                                               // primero por departamento
                                                                               // y luego por
                                                                               // num empleado
                ant = temp;
                temp = temp.next;
            } // end while para numEmp

            nuevoNodo.next = temp;
            ant.next = nuevoNodo;
        //} // end if else que contirne los while

    }// end insertar

    public void Borrar(int numEmp) {
        if (!Vacia()) {
            temp = nc;
            ant = temp;
            while (temp != null && temp.numEmp != numEmp) {
                ant = temp;
                temp = temp.next;
            } // end while que recorre el numEmp siempre y que sea diferente al que queramos
              // borrar

            if (temp == nc) {
                System.out.println("numero de empleado no eiste  " + numEmp);
            } else {
                ant.next = temp.next;
                System.out.println("Se ha eliminado el numero de empleado: " + numEmp);
            } // end if else que borra

        } else {
            System.out.println("La lista esta vacia");
        } // end if else que verifica Vacia()
    }// end borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = nc.next;
            while (temp != nc) {
                System.out.println("NumEmp: " + temp.numEmp + "\tNombre: " + temp.nombre + "\tDepto: " + temp.depto
                        + "\tSueldo: " + temp.sueldo);
                temp = temp.next;
            }
        } else {
            System.err.println("La lista esta vacia");
        } // end if else
    }// end Imprimir Todo

    public void ImprimirPorDepto(int depto) {
        if (!Vacia()) {
            temp = nc.next;
            while (temp != nc) {
                if (temp.depto == depto) {
                    System.out.println("NumEmp: " + temp.numEmp + "\tNombre: " + temp.nombre + "\tDepto: " + temp.depto
                            + "\tSueldo: " + temp.sueldo);
                } // end if para imprimir al empleado
                temp = temp.next;
            } // end while que recorre siempre e imprime siempre que sea el depto
              // correspondiente
        } // end if
    }// end Imprimir Por Depto

    public void ImprimirPrimerElemento() {
        temp = nc;
        temp = temp.next;
        if (!Vacia()) {
            System.out.println("NumEmp: " + temp.numEmp + "\tNombre: " + temp.nombre + "\tDepto: " + temp.depto
                    + "\tSueldo: " + temp.sueldo);
        } else {
            System.out.println("La pila esta vacia");
        } // end if else
    }// end Imprimir primer elemento

    public void Tamano() {
        int contador = 0;
        temp = nc.next;
        while (temp != nc) {
            contador++;
            temp = temp.next;
        } // end while
        System.out.println("La cantidad de la lista es de: " + contador + Vacia());

    }// end tamano

    public void ImprimirPorSueldo(double xSal) {
        temp = nc.next;
        if (!Vacia()) {
            while (temp != nc) {
                if (temp.sueldo >= xSal) {
                    System.out.println("NumEmp: " + temp.numEmp + "\tNombre: " + temp.nombre + "\tDepto: " + temp.depto
                            + "\tSueldo: " + temp.sueldo);
                } // end if
                temp = temp.next;
            } // end while
        } else {
            System.out.println("Vacia");
        } // end if
    }// end Imprimir por sueldo

    public void Invertir() {
        Nodo anterior = nc;
        Nodo p = anterior.next;
        Nodo i = p;
        while (i != nc) {
            i = p.next;
            p.next = anterior;

            anterior = p;
            p = i;
        } // end while para invertir los apuntadores
        nc.next = anterior;
        System.out.print("\n LESC INVERTIDA");
    }// end invertir

    public static void main(String[] args) {
        ListaEncadenadaSimpleCircular lista = new ListaEncadenadaSimpleCircular();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("====== MENU LISTA SIMPLE CIRCULAR ======");
            System.out.println("1. Insertar elemento ordenado por número de empleado");
            System.out.println("2. Borrar elemento por número de empleado");
            System.out.println("3. Imprimir todos los elementos de la lista");
            System.out.println("4. Imprimir nodos con departamento X");
            System.out.println("5. Imprimir primer elemento de la lista");
            System.out.println("6. Imprimir tamaño de la lista");
            System.out.println("7. Imprimir nodos con sueldo mayor o igual a XSAL");
            System.out.println("8. Invertir lista");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número de empleado: ");
                    int numemp = scanner.nextInt();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese departamento: ");
                    int depto = scanner.nextInt();
                    System.out.print("Ingrese sueldo: ");
                    float sueldo = scanner.nextFloat();

                    lista.Insertar(numemp, nombre, depto, sueldo);

                    break;
                case 2:
                    System.out.print("Ingrese número de empleado a borrar: ");
                    numemp = scanner.nextInt();
                    lista.Borrar(numemp);
                    break;
                case 3:
                    lista.ImprimirTodo();
                    break;
                case 4:
                    System.out.print("Ingrese departamento a buscar: ");
                    depto = scanner.nextInt();
                    lista.ImprimirPorDepto(depto);
                    break;
                case 5:
                    lista.ImprimirPrimerElemento();
                    break;
                case 6:
                    lista.Tamano();
                    break;
                case 7:
                    System.out.print("Ingrese salario mínimo: ");
                    float xsal = scanner.nextFloat();
                    lista.ImprimirPorSueldo(xsal);
                    break;
                case 8:
                    lista.Invertir();
                    System.out.println("La lista ha sido invertida");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }// end switch
            System.out.println();
        } while (opcion != 0);
        scanner.close();
    }// end main
}// end class
