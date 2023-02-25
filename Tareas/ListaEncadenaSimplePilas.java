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
            top = top.next;
            System.out.println("Se ha eliminado el empleado: " + temp);
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

}// end class
