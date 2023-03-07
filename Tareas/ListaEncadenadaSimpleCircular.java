package Tareas;

public class ListaEncadenadaSimpleCircular {

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

    Nodo ant;
    Nodo temp;
    Nodo nuevoNodo;
    Nodo nc;

    public void AgregarNC() {
        nuevoNodo = new Nodo(0, null, 0, 0);
        nc = nuevoNodo;
    }// end AgregarNC

    public boolean Vacia() {
        return temp == nc;
    }// end Vacia

    public void Insertar(int numEmp, String nombre, int depto, float sueldo) {
        nuevoNodo = new Nodo(numEmp, nombre, depto, sueldo);
        if (Vacia()) {
            nc.next = nuevoNodo;
            temp = nuevoNodo;
        } else {
            temp = nc;
            ant = temp;
            while (temp != null && temp.depto <= depto && temp.numEmp < numEmp) {// Recore ant y temp
                                                                                 // hasta que se acomode
                                                                                 // primero por departamento
                                                                                 // y luego por
                                                                                 // num empleado
                ant = temp;
                temp = temp.next;
            } // end while para numEmp

            if (ant == nc) {
                temp.next = nuevoNodo;
            } else {
                ant.next = nuevoNodo;
            } // end if else que agrega los datos
            nuevoNodo.next = temp;
        } // end if else que contirne los while
    }// end insertar

    public void Borrar(int numEmp) {
        if (!Vacia()) {
            temp = nc;
            ant = temp;
            while (temp != null && temp.numEmp != numEmp) {
                ant = temp;
                temp = temp.next;
            } // end while que recorre el numEmp siempre y que sea diferente al que queramos
              // borrar

            if (temp == nc) {
                System.out.println("numero de empleado no eiste  " + numEmp);
            } else {
                ant.next = temp.next;
                System.out.println("Se ha eliminado el numero de empleado: " + numEmp);
            } // end if else que borra

        } else {
            System.out.println("La lista esta vacia");
        } // end if else que verifica Vacia()
    }// end borrar

    public void ImprimirTodo() {
        if (!Vacia()) {
            temp = nc;
            while (temp.next != nc) {
                System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                temp = temp.next;
            }
        } else {
            System.err.println("La lista esta vacia");
        } // end if else
    }// end Imprimir Todo

    public void ImprimirPorDepto(int depto) {
        if (!Vacia()) {
            temp = nc;
            while (temp != null) {
                if (temp.depto == depto) {
                    System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                } // end if para imprimir al empleado
                temp = temp.next;
            } // end while que recorre siempre e imprime siempre que sea el depto
              // correspondiente
        } // end if
    }// end Imprimir Por Depto

    public void ImprimirPrimerElemento() {
        temp = nc;
        temp = temp.next;
        if (!Vacia()) {
            System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
        } else {
            System.out.println("La pila esta vacia");
        } // end if else
    }// end Imprimir primer elemento

    public void Tamano() {
        int contador = 0;
        if (!Vacia()) {
            temp = nc;
            while (temp != nc) {
                contador++;
                temp = temp.next;
            } // end while
            System.out.println("La cantidad de la lista es de: "+contador );
        } // end if
    }//end tamano
    
}// end class
