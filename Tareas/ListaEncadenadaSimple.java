package Tareas;

import java.util.Scanner;

public class ListaEncadenadaSimple {

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

    Nodo first;
    Nodo ant;
    Nodo temp;
    Nodo nuevoNodo;

    public ListaEncadenadaSimple() {
        this.first = null;
        this.ant = null;
        this.temp = null;
        this.nuevoNodo = null;
    }// end costructor de Lista encadenada

    public boolean Vacia() {
        return first == null;
    }// end Vacia

    public void Insertar(int numEmp, String nombre, int depto, float sueldo) {
        nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
        boolean repite = true;
        while (temp != null && temp.numEmp <= numEmp) {// recorre y compara los numEmp para que no se repitan
            ant = temp;
            temp = temp.next;

            if (temp.numEmp == numEmp) {
                System.out.println("No se puede repetir numero de empleado");
                repite = true;
            } else {
                repite = false;
            }
        } // end while

        if (!repite) {
            if (Vacia()) {
                first = nuevoNodo;
            } else {
                temp = first;
                ant = temp;

                while (temp != null && temp.depto < depto) {// aqui es un while que recorre el temp y el ant hasta
                                                            // que el
                                                            // departamento sea menor que el que se esta insertando
                    ant = temp;
                    temp = temp.next;
                } // end while para depto

                while (temp != null && temp.depto == depto && temp.numEmp < numEmp) {// una vez ya ordenado por
                                                                                     // departametno
                                                                                     // este lo recorre por numero
                                                                                     // de
                                                                                     // elempleado
                    ant = temp;
                    temp = temp.next;
                } // end while para numEmp

                if (temp == first) {
                    nuevoNodo.next = first;
                    first = nuevoNodo;
                } else {
                    nuevoNodo.next = ant.next;
                    ant.next = nuevoNodo;
                } // end if else que agrega los datos
            } // end if else que contirne los while
        } // end if donde se valida qeu se repita el numero de empleado
    }// end Insertar

    public void Borrar(int numEmp) {
        if (!Vacia()) {
            temp = first;
            ant = null;

            while (temp != null && temp.numEmp != numEmp) {
                ant = temp;
                temp = temp.next;
            } // end while que recorre el numEmp siempre y que sea diferente al que queramos
              // borrar

            if (temp != null) {
                if (ant == null) {
                    first = temp.next; // en caso de que sea el primero
                } else {
                    ant.next = temp.next;
                } // end if else para borrar el elemento dependiendo del caso
                System.out.println("Se ha borrado el empleado numero: " + numEmp);
            } // end if para borrar elemento
        } else {
            System.out.println("Esta vacia la lista");
        } // end if else que verifica si esta vacia o no
    }// end Borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = first;

            while (temp != null) {
                System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                temp = temp.next;
            } // end while para imprimir
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// en imprimir todo

    public void ImprimirPorDepto(int depto) {
        if (!Vacia()) {
            temp = first;

            while (temp != null) {
                if (temp.depto == depto) {
                    System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                } // end if para imprimir al empleado

                temp = temp.next;
            } // end while que recorre siempre e imprime siempre que sea el depto
              // correspondiente
        } // end if
    }// end Imprimir Por Depto

    public void ImprimirPrimerElemento() {
        if (!Vacia()) {
            System.out.println(first.numEmp + "\t" + first.nombre + "\t" + first.depto + "\t" + first.sueldo);
        } else {
            System.out.println("La pila esta vacia");
        } // end if else
    }// end Imprimir primer elemento

    public void Tamano() {
        int contador = 0;

        if (!Vacia()) {
            temp = first;

            while (temp != null) {
                contador++;
                temp = temp.next;
            } // end while
        } // end if

        System.out.println("La cantidad de epleados es de: " + contador);
    }// end Tamano

    public void ImprimirPorSueldo(double xSal) {
        temp = first;
        while (temp != null) {
            if (temp.sueldo >= xSal) {
                System.out.println("NumEmp: " + temp.numEmp + ", Nombre: " + temp.nombre + ", Depto: " + temp.depto
                        + ", Sueldo: " + temp.sueldo);
            } // end if
            temp = temp.next;
        } // end while
    }// end Imprimir por sueldo

    public void Invertir() {
        ant = null;
        temp = first;
        first = null;
        while (temp != null) {
            ant = temp;
            temp = temp.next;
            ant.next = first;
            first = ant;
        } // end while que recorre e invierte la direccion de los apuntadores, para asi
          // invertirlos
    }// end Invertir

    // main
    public static void main(String[] args) {
        ListaEncadenadaSimple lista = new ListaEncadenadaSimple();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("====== MENU LISTA SIMPLE ======");
            System.out.println("1. Insertar elemento ordenado por número de empleado");
            System.out.println("2. Borrar elemento por número de empleado");
            System.out.println("3. Imprimir todos los elementos de la lista");
            System.out.println("4. Imprimir nodos con departamento X");
            System.out.println("5. Imprimir primer elemento de la lista");
            System.out.println("6. Imprimir tamaño de la lista");
            System.out.println("7. Imprimir nodos con sueldo mayor o igual a XSAL");
            System.out.println("8. Invertir lista");
            System.out.println("9. Salir");
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número de empleado: ");
                    int numemp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese departamento: ");
                    int depto = scanner.nextInt();
                    System.out.print("Ingrese sueldo: ");
                    float sueldo = scanner.nextFloat();

                    Nodo nodo = lista.new Nodo(numemp, nombre, depto, sueldo);
                    lista.Insertar(nodo);

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
