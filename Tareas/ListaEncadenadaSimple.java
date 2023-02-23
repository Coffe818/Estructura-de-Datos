package Tareas;

import javax.swing.JOptionPane;

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

        if (first == null) {
            first = nuevoNodo;
        } else {
            ant = null;
            temp = first;

            while (temp != null && temp.depto <= depto && temp.numEmp < numEmp) {// Recore ant y temp
                                                                                 // hasta que se acomode
                                                                                 // primero por departamento
                                                                                 // y luego por
                                                                                 // num empleado
                ant = temp;
                temp = temp.next;
            } // end while para numEmp

            if (ant == null) {
                first = nuevoNodo;
                JOptionPane.showMessageDialog(null, "elementos agregados correctamente");
            } else {
                ant.next = nuevoNodo;
                JOptionPane.showMessageDialog(null, "elementos agregados correctamente");
            } // end if else que agrega los datos
            nuevoNodo.next = temp;
        } // end if else que contirne los while

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
                JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + numEmp);
            } // end if para borrar elemento
        } else {
            JOptionPane.showMessageDialog(null, "Esta vacia la lista");
        } // end if else que verifica si esta vacia o no
    }// end Borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = first;
            String mensaje="";
            while (temp != null) {
                mensaje += temp.numEmp + "  " + temp.nombre + "  " + temp.depto + "  " + temp.sueldo+"\n";
                
                temp = temp.next;
            } // end while para imprimir
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// en imprimir todo

    public void ImprimirPorDepto(int depto) {
        if (!Vacia()) {
            temp = first;
            String mensaje="";
            while (temp != null) {
                if (temp.depto == depto) {
                    mensaje += temp.numEmp + "  " + temp.nombre + "  " + temp.depto + "  " + temp.sueldo+"\n";                    
                } // end if para imprimir al empleado

                temp = temp.next;
            } // end while que recorre siempre e imprime siempre que sea el depto
              // correspondiente
              JOptionPane.showMessageDialog(null, mensaje);
        } // end if
    }// end Imprimir Por Depto

    public void ImprimirPrimerElemento() {
        if (!Vacia()) {
            String mensaje = first.numEmp + "  " + first.nombre + "  " + first.depto + "  " + first.sueldo+"\n";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
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

        JOptionPane.showMessageDialog(null, "La cantidad de epleados es de: " + contador);
    }// end Tamano

    public void ImprimirPorSueldo(double xSal) {
        temp = first;
        if (!Vacia()) {
            while (temp != null) {
                if (temp.sueldo >= xSal) {
                    String mensaje = temp.numEmp + "  " + temp.nombre + "  " + temp.depto + "  " + temp.sueldo+"\n";
                    JOptionPane.showMessageDialog(null, mensaje);
                } // end if
                temp = temp.next;
            } // end while
        } else {
            JOptionPane.showMessageDialog(null, "Vacia");
        } // end if
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
        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU LISTA SIMPLE ======\n"
                    + "1. Insertar elemento ordenado por número de empleado\n"
                    + "2. Borrar elemento por número de empleado\n"
                    + "3. Imprimir todos los elementos de la lista\n"
                    + "4. Imprimir nodos con departamento X\n"
                    + "5. Imprimir primer elemento de la lista\n"
                    + "6. Imprimir tamaño de la lista\n"
                    + "7. Imprimir nodos con sueldo mayor o igual a XSAL\n"
                    + "8. Invertir lista\n"
                    + "9. Salir\n"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int numemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de empleado: "));
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre: ");
                    int depto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese departamento: "));
                    float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese sueldo"));

                    lista.Insertar(numemp, nombre, depto, sueldo);

                    break;
                case 2:
                    numemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de empleado: "));
                    lista.Borrar(numemp);
                    break;
                case 3:
                    lista.ImprimirTodo();
                    break;
                case 4:
                    depto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese departamento: "));
                    lista.ImprimirPorDepto(depto);
                    break;
                case 5:
                    lista.ImprimirPrimerElemento();
                    break;
                case 6:
                    lista.Tamano();
                    break;
                case 7:
                    float xsal = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese salario minimo"));

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

    }// end main

}// end class
