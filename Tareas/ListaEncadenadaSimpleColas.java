package Tareas;

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
    public void Invertir() {
        if (!Vacia()) {
            ant = null;
            temp =inicio;
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
    
}// end class
