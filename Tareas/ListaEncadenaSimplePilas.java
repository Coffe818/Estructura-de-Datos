package Tareas;

import java.util.Scanner;

public class ListaEncadenaSimplePilas {
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

    Nodo top;
    Nodo temp;
    Nodo ant;
    Nodo nuevoNodo;
    int cantidad;

    // constructor
    public ListaEncadenaSimplePilas() {
        top = null;
        temp = null;
        ant = null;
        cantidad = 0;
    }// end contructor

    public boolean Vacia() {
        return top == null;
    }// end vacia

    public void InsertarElemento(int numEmp, String nombre, int depto, float sueldo) {
        Nodo nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
        if (Vacia()) {
            top = nuevoNodo;
        } else {
            temp = top;
            while (temp.next != null) {
                temp = temp.next;
            } // end while
            temp.next = nuevoNodo;
        } // end fi else recorre el top hasta el final y ahi agrega el nodod
        cantidad++;
    }// end Insertar elemento

    public void Borrar() {
        if (!Vacia()) {
            temp = top;
            ant = null;

            while (temp.next != null) {
                ant = temp;
                temp = temp.next;
            } // recorre ant y temp hasta el final

            if (ant == null) {
                top = null;
            } else {
                ant.next = null;
            } // borra dependiendo de si es el primero y deja la cola vacia o sino y borra el
              // ultimo

            System.out.println("Se borro el empleado numero: "+ temp.numEmp);
            cantidad--;
        } else {
            System.out.println("La lista esta vaica");
        } // if else
    }// end Borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = top;
            while (temp != null) {
                System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                temp = temp.next;
            } // recorre el temp y imprime los datos
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end Imprimir todo

    public void ImprimirDept(int depto) {
        if (!Vacia()) {
            temp = top;
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

    public void ImprimirUltimo() {
        if (!Vacia()) {
            temp = top;
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// ens imprimir ultimo

    public void Tamano() {
        System.out.println("Tamaño de la lista: " + cantidad);
    }// end tamano

    public void ImprimirSueldo(float xsal) {
        if (!Vacia()) {
            temp = top;
            while (temp != null) {
                if (temp.sueldo >= xsal) {
                    System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                } // end for
                temp = temp.next;
            } // end while
        } else {
            System.out.println("La lista esta vacia");
        }
    }// end Imprimir Sueldo

    public void Invertir() {
        if (!Vacia()) {
            temp = top;
            ant = null;
            while (temp != null) {
                Nodo siguiente = temp.next;// se agrego esta variable
                temp.next = ant;
                ant = temp;
                temp = siguiente;
            } // end while
            top = ant;
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// ens Invertir

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ListaEncadenaSimplePilas lista = new ListaEncadenaSimplePilas();
        int opcion;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Insertar un elemento" +
                    "\n2. Borrar un elemento" +
                    "\n3. Imprimir todos los elementos" +
                    "\n4. Imprimir los nodos con el DEPTO igual a X" +
                    "\n5. Imprimir el ULTIMO elemento" +
                    "\n6. Imprimir el tamaño de la lista" +
                    "\n7. Imprimir los nodos con SUELDO >= XSAL" +
                    "\n8. Invertir la lista" +
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
                    lista.InsertarElemento(numemp, nombre, depto, sueldo);
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
                    lista.Tamano();
                    break;
                case 7:
                    System.out.print("Ingrese el sueldo: ");
                    sueldo = s.nextFloat();
                    lista.ImprimirSueldo(sueldo);
                    break;
                case 8:
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
