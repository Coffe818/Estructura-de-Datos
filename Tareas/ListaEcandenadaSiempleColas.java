package Tareas;

public class ListaEcandenadaSiempleColas {
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
    //constructor
    public ListaEcandenadaSiempleColas(){
        inicio=null;
        fin =null;
        temp=null;
        ant=null;
    }//end constructor

    public boolean Vacia() {
        return inicio == null;
    }// end vacia
    
}//end class
