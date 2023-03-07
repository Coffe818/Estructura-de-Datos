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
            ant = nc;
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
            ant = nc;
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
            }//end if else que borra

        } else {
            System.out.println("Esta vacia");
        }//end if else que verifica Vacia()
    }// end borrar

}// end class
