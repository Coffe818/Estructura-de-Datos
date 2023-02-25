package Tareas;

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

    // constructor
    public ListaEncadenaSimplePilas() {
        top = null;
        temp = null;
        ant = null;
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
          // size++;
    }// end Insertar elemento

    public void Borrar() {
        if (!Vacia()) {
            temp = top;
            top = top.next;
            System.out.println("Se ha eliminado el empleado: " + temp);
            // size--;
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
        temp = top;

        while (temp != null) {
            if (temp.depto == depto) {
                System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
            }//end if que imprime siempre que sea del dapartamento
            temp = temp.next;
        }// end while
    }//end Imprimir Dept

}// end class
