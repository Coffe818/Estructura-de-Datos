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
        boolean repite =true;
        while (temp != null && temp.numEmp <= numEmp) {//recorre y compara los numEmp para que no se repitan
                        ant = temp;
                        temp = temp.next;
                    
            if (temp.numEmp == numEmp) {
                System.out.println("No se puede repetir numero de empleado");
                repite=true;
            }else{
                repite=false;
            }
        }//end while

            if (!repite) {
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
                    } else {
                        nuevoNodo.next = ant.next;
                        ant.next = nuevoNodo;
                    }//end if else que agrega los datos
                } // end if else que contirne los while
            }//end if donde se valida qeu se repita el numero de empleado           
    }// end Insertar

    public void Borrar(int numEmp) {
        if (!Vacia()) {
            temp = first;
            ant = null;
            
            while (temp != null && temp.numEmp != numEmp) {
                ant = temp;
                temp = temp.next;
            }//end while que recorre el numEmp siempre y que sea diferente al que queramos borrar
            
            if (temp != null) {
                if (ant == null) {
                    first = temp.next; //en caso de que sea el primero                    
                } else {
                    ant.next = temp.next;                     
                }//end if else para borrar el elemento dependiendo del caso
                System.out.println("Se ha borrado el empleado numero: "+ numEmp);
            }// end if para borrar elemento
        }else{
            System.out.println("Esta vacia la lista");
        }//end if else que verifica si esta vacia o no
    }//end Borrar

    public void ImprimirPorDepto(int depto) {
        if (!Vacia()) {
            temp = first;
            
            while (temp != null) {
                if (temp.depto == depto) {
                    System.out.println(temp.numEmp + "\t" + temp.nombre + "\t" + temp.depto + "\t" + temp.sueldo);
                }// end if para imprimir al empleado 
                
                temp = temp.next;
            }//end while que recorre siempre e imprime siempre que sea el depto correspondiente
        }//end if
    }//end Imprimir Por Depto

    
    public void ImprimirPrimerElemento() {
        if (!Vacia()) {
            System.out.println(first.numEmp + "\t" + first.nombre + "\t" + first.depto + "\t" + first.sueldo);
        }else{
            System.out.println("La pila esta vacia");
        }// end if else
    }//end Imprimir primer elemento

    public void Tamano() {
        int contador = 0;
        
        if (!Vacia()) {
            temp = first;
            
            while (temp != null) {
                contador++;
                temp = temp.next;
            }//end while
        }//end if
        
        System.out.println("La cantidad de epleados es dees de: "+contador);
    }//end Tamano
}// end class
