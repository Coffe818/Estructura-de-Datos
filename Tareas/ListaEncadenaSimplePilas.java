package Tareas;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    }

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
        nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
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

            JOptionPane.showMessageDialog(null, "Se ha borrado el empleado numero: " + temp.numEmp);
            cantidad--;
        } else {
            JOptionPane.showMessageDialog(null, "Esta vacia la lista");
        } // if else
    }// end Borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = top;
            NombreColumnas();
            while (temp != null) {
                AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                temp = temp.next;
            } // recorre el temp y imprime los datos
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end Imprimir todo

    public void ImprimirDept(int depto) {
        if (!Vacia()) {
            temp = top;
            NombreColumnas();
            while (temp != null) {
                if (temp.depto == depto) {
                    AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
                } // end if que imprime siempre que sea del dapartamento
                temp = temp.next;
            } // end while
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// end Imprimir Dept

    public void ImprimirUltimo() {
        if (!Vacia()) {
            temp = top;
            NombreColumnas();
            while (temp.next != null) {
                temp = temp.next;
            } // recorre a temp hasta el final
            AgregarDatos(temp.numEmp, temp.nombre, temp.depto, temp.sueldo);
            ImprimirTabla();
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// ens imprimir ultimo

    public void Tamano() {
        JOptionPane.showMessageDialog(null, "El tamano de la lista es de: " + cantidad);
    }// end tamano

    public void ImprimirSueldo(float xsal) {
        if (!Vacia()) {
            temp = top;
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
            temp = top;
            top = null;
            while (temp != null) {
                ant = temp;
                temp = temp.next;
                ant.next = top;
                top = ant;
            } // end while
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } // end if else
    }// ens Invertir

    public static void main(String[] args) {
        ListaEncadenaSimplePilas lista = new ListaEncadenaSimplePilas();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU LISTA SIMPLE ======\n"
                    + "1. Insertar elemento ordenado por número de empleado\n"
                    + "2. Borrar elemento por número de empleado\n"
                    + "3. Imprimir todos los elementos de la lista\n"
                    + "4. Imprimir nodos con departamento X\n"
                    + "5. Imprimir ULTIMO elemento insertado en la lista\n"
                    + "6. Imprimir tamaño de la lista\n"
                    + "7. Imprimir nodos con sueldo mayor o igual a XSAL\n"
                    + "8. Invertir lista\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int numemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de empleado: "));
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre: ");
                    int depto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese departamento: "));
                    float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese sueldo"));
                    lista.InsertarElemento(numemp, nombre, depto, sueldo);
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
                    lista.Tamano();
                    break;
                case 7:
                    float xsal = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese salario minimo"));
                    lista.ImprimirSueldo(xsal);
                    break;
                case 8:
                    lista.Invertir();
                    JOptionPane.showMessageDialog(null, "La lista se ha invertido correctamente");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }
        } while (opcion != 0);

    }// end main
}// end class
