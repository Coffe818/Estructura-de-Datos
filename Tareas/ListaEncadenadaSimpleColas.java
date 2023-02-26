package Tareas;

import java.util.Scanner;

public class ListaEncadenadaSimpleColas {
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

    Nodo inicio;
    Nodo fin;
    Nodo temp;
    Nodo ant;
    Nodo nuevoNodo;

    // constructor
    public ListaEncadenadaSimpleColas() {
        inicio = null;
        fin = null;
        temp = null;
        ant = null;
    }// end constructor

    public boolean Vacia() {
        return inicio == null;
    }// end vacia

    public void Insertar(int numEmp, String nombre, int depto, float sueldo) {
        nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
        if (!Vacia()) {
            fin.next = nuevoNodo;
            fin = nuevoNodo;
        } else {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } // end if else
    }// end insertar

    public void Borrar() {
        if (!Vacia()) {
            temp = inicio;
            inicio = inicio.next;
            if (inicio == null) {
                fin = null;
            } // significa que ahora esta vacia
            System.out.println("Se ha eliminado el emplado numero: " + temp.numEmp);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = inicio;
            while (temp != null) {
                System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                temp = temp.next;
            } // end while
        } else {
            System.out.println("La cola esta vacia");
        } // end if else
    }// end imprimir todo

    public void ImprimirDept(int depto) {
        if (!Vacia()) {
            temp = inicio;
            while (temp != null) {
                if (temp.depto == depto) {
                    System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                } // end if que imprime siempre que sea del dapartamento
                temp = temp.next;
            } // end while
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end Imprimir Dept

    public void ImprimirPrimer() {
        if (!Vacia()) {
            temp = inicio;
            System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end imprimir ultimo

    public void ImprimirUltimo() {
        if (!Vacia()) {
            temp = fin;
            System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end imprimir ultimo

    public void Tamano() {
        int contador = 0;
        if (!Vacia()) {
            temp = inicio;
            while (temp != null) {
                contador++;
                temp = temp.next;
            } // end while
        } // end if
        System.out.println("La cantidad de epleados es de: " + contador);
    }// end Tamano

    public void ImprimirSueldo(float xsal) {
        if (!Vacia()) {
            temp = inicio;
            while (temp != null) {
                if (temp.sueldo >= xsal) {
                    System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                } // end for
                temp = temp.next;
            } // end while
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end Imprimir Sueldo

    public void Invertir() {
        if (!Vacia()) {
            ant = null;
            temp = inicio;
            inicio = null;
            while (temp != null) {
                ant = temp;
                temp = temp.next;
                ant.next = inicio;
                inicio = ant;
            } // end while
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// ens Invertir

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ListaEncadenadaSimpleColas lista = new ListaEncadenadaSimpleColas();
        int opcion;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Insertar un elemento" +
                    "\n2. Borrar un elemento" +
                    "\n3. Imprimir todos los elementos" +
                    "\n4. Imprimir los nodos con el DEPTO igual a X" +
                    "\n5. Imprimir el ULTIMO elemento" +
                    "\n6. Imprimir el PRIMER elemento" +
                    "\n7. Imprimir el tamaño de la lista" +
                    "\n8. Imprimir los nodos con SUELDO >= XSAL" +
                    "\n9. Invertir la lista" +
                    "\n0. Salir" +
                    "\nIngrese una opcion: ");
            opcion = s.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero de empleado: ");
                    int numemp = s.nextInt();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = s.next();
                    System.out.print("Ingrese el departamento: ");
                    int depto = s.nextInt();
                    System.out.print("Ingrese el sueldo: ");
                    float sueldo = s.nextFloat();
                    lista.Insertar(numemp, nombre, depto, sueldo);
                    System.out.println("Elemento insertado correctamente");
                    break;
                case 2:
                    lista.Borrar();
                    break;
                case 3:
                    lista.ImprimirTodo();
                    break;
                case 4:
                    System.out.print("Ingrese el departamento: ");
                    depto = s.nextInt();
                    lista.ImprimirDept(depto);
                    break;
                case 5:
                    lista.ImprimirUltimo();
                    break;
                case 6:
                    lista.ImprimirPrimer();
                    break;
                case 7:
                    lista.Tamano();
                    break;
                case 8:
                    System.out.print("Ingrese el sueldo: ");
                    sueldo = s.nextFloat();
                    lista.ImprimirSueldo(sueldo);
                    break;
                case 9:
                    lista.Invertir();
                    System.out.println("La lista se ha invertido correctamente");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 0);

        s.close();
    }// end main

}// end class
