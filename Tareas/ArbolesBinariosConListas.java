package Tareas;

import java.util.LinkedList;

public class ArbolesBinariosConListas {
    // esta clase es para el arbol
    public class NodoB {
        int NumEmp;
        String NomEmp;
        float Sueldo;
        NodoB LCHILD;
        NodoB RCHILD;

        public NodoB(int NumEmp, String NomEmp, float Sueldo) {
            this.NumEmp = NumEmp;
            this.NomEmp = NomEmp;
            this.Sueldo = Sueldo;
            this.LCHILD = null;
            this.RCHILD = null;
        }// end constructor
    }// end class NodoB

    NodoB raiz;
    NodoB NuevoNodoB;

    // esta clase es para la lista
    LinkedList<Integer> cola = new LinkedList<Integer>();

    public class NodoL {
        int NumEmp;
        String NomEmp;
        float Sueldo;
        NodoL next;

        public NodoL(int NumEmp, String NomEmp, float Sueldo) {
            this.NumEmp = NumEmp;
            this.NomEmp = NomEmp;
            this.Sueldo = Sueldo;
        }// end constructor
    }// end class NODOB

    NodoL ant;
    NodoL temp;
    NodoL NuevoNodoL;
    NodoL nc;

    public ArbolesBinariosConListas() {
        NuevoNodoL = new NodoL(0, null, 0);
        nc = NuevoNodoL;
        nc.next = nc;
        temp = nc;
    }// end contstructor y deja nc vacio

    public void AltaEnArbol(int numEmp, String nombre, float sueldo) {
        NuevoNodoB = new NodoB(numEmp, nombre, sueldo);
        if (raiz == null) {
            raiz = NuevoNodoB;
        } else {
            NodoB actual = raiz;
            NodoB padre;
            while (true) {
                padre = actual;
                if (numEmp < actual.NumEmp) {
                    actual = actual.LCHILD;
                    if (actual == null) {
                        padre.LCHILD = NuevoNodoB;
                        return;
                    } // end if para agregar el nodo
                } else {
                    actual = actual.RCHILD;
                    if (actual == null) {
                        padre.RCHILD = NuevoNodoB;
                        return;
                    } // end if para agregar el nodo
                } // end if para agregar el nodo ya sea derecha o izquierda
            } // end while para saber a donde dirigirse
        } // end if else de raiz
    }// end Agregar Nodo o alta de un nodo en el arbol

    public void AltaEnLista(int numEmp, String nombre, float sueldo) {
        NuevoNodoL = new NodoL(numEmp, nombre, sueldo);

        temp = nc.next;
        ant = nc;
        while (temp != nc && temp.NumEmp < numEmp) {// Recore ant y temp
                                                    // hasta que se acomode por
                                                    // num empleado
            ant = temp;
            temp = temp.next;
        } // end while para numEmp
        NuevoNodoL.next = temp;
        ant.next = NuevoNodoL;
    }// end insertar

}// end class
