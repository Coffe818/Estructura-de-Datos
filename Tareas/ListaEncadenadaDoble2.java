package Tareas;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaEncadenadaDoble2 {
    public class Nodo {
        int numEmp;
        String nombre;
        int depto;
        float sueldo;
        Nodo next;// apuntadores
        Nodo prev;

        public Nodo(int numEmp, String nombre, int depto, float sueldo) {
            this.numEmp = numEmp;
            this.nombre = nombre;
            this.depto = depto;
            this.sueldo = sueldo;
            this.next = null;
        }// end constructor
    }// end class nodo

    Nodo ant;
    Nodo temp;
    Nodo sig;
    Nodo nuevoNodo;
    Nodo nc;
    DefaultTableModel modelo = new DefaultTableModel();// aqui agrego los datos
    JTable tabla = new JTable();// aqui se agregan a la tabla
    JScrollPane scrollPane = new JScrollPane();// en cso de que sea muy grande y necesite parras de desplasamiento

    public void NombreColumnas() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Num. Emp");
        modelo.addColumn("Nombre");
        modelo.addColumn("Depto");
        modelo.addColumn("Sueldo");
    }// end Nombre columnas

    public void AgregarDatos(int numEmp, String nombre, int depto, float sueldo) {
        Object[] fila = { numEmp, nombre, depto, sueldo };
        modelo.addRow(fila);
    }// end agregar datos

    public void ImprimirTabla() {
        tabla = new JTable(modelo);
        scrollPane = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(null, scrollPane);
    }// end imprimirTabla

    public ListaEncadenadaDoble2() {
        nuevoNodo = new Nodo(0, "", 0, 0);
        nc = nuevoNodo;
        nc.next = nc;
        nc.prev = nc;
    }

    public boolean Vacia() {
        return nc.next == nc;
    }// end vacia

    public void Insertar(int numEmp, String nombre, int depto, float sueldo) {
        nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
        temp = nc.next;

        while (temp != nc && temp.numEmp <= numEmp) {
            temp = temp.next;
        } // end while para recorrer el temp por numero de empleado
        while (temp != nc && temp.numEmp == numEmp && temp.depto <= depto) {
            temp = temp.next;
        } // end ahile para recoorer por departamanep

        ant = temp.prev;
        nuevoNodo.next = temp;
        nuevoNodo.prev = ant;// temp.prev;
        temp.prev = nuevoNodo;
        ant.next = nuevoNodo;
    }// end Insertar

    public void Borrar(int numEmp) {
        if (!Vacia()) {
            temp = nc.next;
            while (temp != nc && temp.numEmp != numEmp) {
                temp = temp.next;
            } // end while que recorre el temp

            ant = temp.prev;
            sig = temp.next;
            ant.next = sig;
            sig.prev = ant;
            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + temp.numEmp);

        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end Borrar

    public void ImprimirNext() {
        temp = nc.next;
        if (!Vacia()) {
            NombreColumnas();
            while (temp != nc) {
                AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                temp = temp.next;
            } // end while que imprime y recorre temp a la derecha
            ImprimirTabla();

        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }// end Imprimir Next

    public void ImprimirPrev() {
        temp = nc.prev;
        if (!Vacia()) {
            NombreColumnas();
            while (temp != nc) {
                AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                temp = temp.prev;
            } // end while que imprime y recorre temp a la izquierda
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }// end Imprimir Prev

    public void Tamano() {
        int contador = 0;
        temp = nc.next;
        while (temp != nc) {
            contador++;
            temp = temp.next;
        } // end while
        JOptionPane.showMessageDialog(null, "La cantidad de la lista es de: " + contador);

    }// end tamano

    public void PrecioMayor() {

        Nodo Mayor = nc;
        temp = temp.next;
        NombreColumnas();
        while (temp != nc) {

            if (temp.sueldo > Mayor.sueldo) {
                Mayor = temp;
            } // si el precio de temporal es mayor al precio mayor que ya tenia el mayor se
              // mueve al temporal

            temp = temp.next;
        } // end while que imprime y recorre temp a la izquierda
        AgregarDatos(Mayor.numEmp, Mayor.nombre, Mayor.depto, Mayor.sueldo);
        ImprimirTabla();
    }// end Precio Mayor

    public void ImprimirPorDepto(int depto) {
        if (!Vacia()) {
            temp = nc.next;
            modelo = new DefaultTableModel();
            NombreColumnas();

            while (temp != nc) {
                if (temp.depto == depto) {
                    AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                } // end if para imprimir al empleado

                temp = temp.next;
            } // end while que recorre siempre e imprime siempre que sea el depto
              // correspondiente
            ImprimirTabla();
        } // end if
    }// end Imprimir Por Depto

    public static void main(String[] args) {
        ListaEncadenadaDoble2 lis = new ListaEncadenadaDoble2();
        int opcion;
        Scanner s = new Scanner(System.in);

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("============Menu Lista Doble 2.0=========="
                    + "\n1. Insertar elemento"
                    + "\n2. Eliminar un x Nodo"
                    + "\n3. Imprimir Cantidad de elementos"
                    + "\n4. Imprimir hacia la derecha "
                    + "\n5. Imprimir hacia la izquierda"
                    + "\n6. Imprimir el que tiene suedlo Mayor"
                    + "\n7. Imprimir los de cierto departamento"
                    + "\n0. Salir"
                    + "\nSELECCIONE UNA OPCION"));

            switch (opcion) {
                case 1:
                    int numemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de empleado: "));
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre: ");
                    int depto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese departamento: "));
                    float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese sueldo"));

                    lis.Insertar(numemp, nombre, depto, sueldo);
                    break;
                case 2:
                    numemp = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese numero de articulo que desea eliminar: "));
                    lis.Borrar(numemp);
                    break;
                case 3:
                    lis.Tamano();
                    break;
                case 4:
                    lis.ImprimirNext();
                    break;
                case 5:
                    lis.ImprimirPrev();
                    break;
                case 6:
                    lis.PrecioMayor();
                    break;
                case 7:
                    depto = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese numero de articulo que desea eliminar: "));
                    lis.ImprimirPorDepto(depto);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrece una opcion valida");
                    break;
            }
        } while (opcion != 0);

        s.close();
    }// end main

}// end class
