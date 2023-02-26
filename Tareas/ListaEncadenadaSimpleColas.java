package Tareas;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    }// end imprimir tabla

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
            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + temp.numEmp);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = inicio;
            NombreColumnas();
            while (temp != null) {
                AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                temp = temp.next;
            } // end while
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end imprimir todo

    public void ImprimirDept(int depto) {
        if (!Vacia()) {
            temp = inicio;
            NombreColumnas();
            while (temp != null) {
                if (temp.depto == depto) {
                    AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                    ;
                } // end if que imprime siempre que sea del dapartamento
                temp = temp.next;
            } // end while
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end Imprimir Dept

    public void ImprimirPrimer() {
        if (!Vacia()) {
            temp = inicio;
            NombreColumnas();
            AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end imprimir ultimo

    public void ImprimirUltimo() {
        if (!Vacia()) {
            temp = fin;
            NombreColumnas();
            AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
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
        JOptionPane.showMessageDialog(null, "El tamano de la lista es de: " + contador);
    }// end Tamano

    public void ImprimirSueldo(float xsal) {
        if (!Vacia()) {
            temp = inicio;
            NombreColumnas();
            while (temp != null) {
                if (temp.sueldo >= xsal) {
                    AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                } // end for
                temp = temp.next;
            } // end while
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
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
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// ens Invertir

    public static void main(String[] args) {

        ListaEncadenadaSimpleColas lista = new ListaEncadenadaSimpleColas();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU LISTA SIMPLE COLAS======\n"
                    + "1. Insertar elemento\n"
                    + "2. Borrar PRIMER elemento insertado\n"
                    + "3. Imprimir todos los elementos de la lista\n"
                    + "4. Imprimir nodos con departamento X\n"
                    + "5. Imprimir ULTIMO elemento insertado en la lista\n"
                    + "6. Imprimir PRIMER elemento insertado\n"
                    + "7. Imprimir tamaño de la lista\n"
                    + "8. Imprimir nodos con sueldo mayor o igual a XSAL\n"
                    + "9. Invertir lista\n"
                    + "0. Salir\n"
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
                    lista.Borrar();
                    break;
                case 3:
                    lista.ImprimirTodo();
                    break;
                case 4:
                    depto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese departamento: "));
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
                    float xsal = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese salario minimo"));
                    lista.ImprimirSueldo(xsal);
                    break;
                case 9:
                    lista.Invertir();
                    JOptionPane.showMessageDialog(null, "La lista se ha invertido correctamente");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }// end swithc
        } while (opcion != 0);

    }// end main

}// end class
