package Tareas;

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
    int Contador;

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
        while (temp != null && temp.numEmp <= numEmp) {//recorre y compara los numEmp para que no se repitan
                        ant = temp;
                        temp = temp.next;
                    
            if (temp.numEmp == numEmp) {
                System.out.println("No se puede repetir numero de empleado");
            }
            else {
                if (Vacia()) {
                    first = nuevoNodo;
                } else {
                    temp = first;
                    ant = temp;

                    while (temp != null && temp.depto < depto) {// aqui es un while que recorre el temp y el ant hasta
                                                                // que el
                                                                // departamento sea menor que el que se esta insertando
                        ant = temp;
                        temp = temp.next;
                    } // end while para depto

                    while (temp != null && temp.depto == depto && temp.numEmp < numEmp) {// una vez ya ordenado por
                                                                                         // departametno
                                                                                         // este lo recorre por numero
                                                                                         // de
                                                                                         // elempleado
                        ant = temp;
                        temp = temp.next;
                    } // end while para numEmp

                    if (temp == first) {
                        nuevoNodo.next = first;
                        first = nuevoNodo;
                        Contador++;
                    } else {
                        nuevoNodo.next = ant.next;
                        ant.next = nuevoNodo;
                        Contador++;
                    }//end if else que agrega los datos
                } // end if else que contirne los while
            }//end if else que valida que no se repita el numero de empleados
        } // end while
    }// end Insertar

}// end class
