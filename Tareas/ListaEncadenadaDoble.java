package Tareas;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaEncadenadaDoble {
    public class Nodo {
        int numArt;
        String nombre;
        int existencia;
        float precio;
        Nodo next;// apuntadores
        Nodo prev;

        public Nodo(int numArt, String nombre, int existencia, float precio) {
            this.numArt = numArt;
            this.nombre = nombre;
            this.existencia = existencia;
            this.precio = precio;
            this.next = null;
        }// end constructor del nodo
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
        modelo.addColumn("Num. Art");
        modelo.addColumn("Nombre");
        modelo.addColumn("Existenca");
        modelo.addColumn("Precio");
    }// end Nombre columnas

    public void AgregarDatos(int numArt, String nombre, int existencia, float precio) {
        Object[] fila = { numArt, nombre, existencia, precio };
        modelo.addRow(fila);
    }// end agregar datos

    public void ImprimirTabla() {
        tabla = new JTable(modelo);
        scrollPane = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(null, scrollPane);
    }// end imprimir tabla

    public ListaEncadenadaDoble() {
        nuevoNodo = new Nodo(0, "", 0, 0);
        nc = nuevoNodo;
        nc.next = nc;
        nc.prev = nc;
    }

    public boolean Vacia() {
        return nc.next == nc;
    }// end vacia

    public void Insertar(int numArt, String nombre, int existencia, float precio) {
        nuevoNodo = new Nodo(numArt, nombre, existencia, precio);
        temp = nc.next;

        while (temp != nc && temp.numArt <= numArt) {
            temp = temp.next;
        } // end while para recorrer el temp

        ant = temp.prev;
        nuevoNodo.next = temp;
        nuevoNodo.prev = ant;// temp.prev;
        temp.prev = nuevoNodo;
        ant.next = nuevoNodo;
    }// end Insertar

    public void Borrar(int numArt) {
        if (!Vacia()) {
            temp = nc.next;
            while (temp != nc && temp.numArt != numArt) {
                temp = temp.next;
            } // end while que recorre el temp

            ant = temp.prev;
            sig = temp.next;
            ant.next = sig;
            sig.prev = ant;
            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + temp.numArt);

        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end Borrar

    public void ImprimirNext() {
        temp = nc.next;
        if (!Vacia()) {
            NombreColumnas();
            while (temp != nc) {
                AgregarDatos(temp.numArt, temp.nombre, temp.existencia, temp.precio);
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
                AgregarDatos(temp.numArt, temp.nombre, temp.existencia, temp.precio);
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

            if (temp.precio > Mayor.precio) {
                Mayor = temp;
            } // si el precio de temporal es mayor al precio mayor que ya tenia el mayor se
              // mueve al temporal

            temp = temp.next;
        } // end while que imprime y recorre temp a la izquierda
        AgregarDatos(Mayor.numArt, Mayor.nombre, Mayor.existencia, Mayor.precio);
        ImprimirTabla();
    }// end Precio Mayor

    public static void main(String[] args) {
        ListaEncadenadaDoble lis = new ListaEncadenadaDoble();
        int opcion;
        Scanner s = new Scanner(System.in);

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("============Menu Lista Doble=========="
                    + "\n1. Insertar elemento"
                    + "\n2. Eliminar un x Nodo"
                    + "\n3. Imprimir Cantidad de elementos"
                    + "\n4. Imprimir hacia la derecha "
                    + "\n5. Imprimir hacia la izquierda"
                    + "\n6. Imprimir el que tiene precio Mayor"
                    + "\n0. Salir"
                    + "\nSELECCIONE UNA OPCION"));

            switch (opcion) {
                case 1:
                    int numArt = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del articulo: "));
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese en nombre del articulo: ");
                    int existencia = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese la existencia de articulo: "));
                    float precio = Float
                            .parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio del articulo"));

                    lis.Insertar(numArt, nombre, existencia, precio);
                    break;
                case 2:
                    numArt = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese numero de articulo que desea eliminar: "));
                    lis.Borrar(numArt);
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
