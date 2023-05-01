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

    public boolean VaciaLista() {
        return nc.next == nc;
    }// end Vacia

    private boolean VaciaCola() {
        return cola.isEmpty();
    }// end vacia

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

    public void PasarArbolaCola(NodoB nodo, NodoL nodopasar) {
        if (nodo != null) {
            PasarArbolaCola(nodo.LCHILD, nodopasar);
            if (nodo.NumEmp == nodopasar.NumEmp) {
                cola.add(nodo.NumEmp);
            } // end if para pasar el nodo si es igual al numemp que queremos
            PasarArbolaCola(nodo.RCHILD, nodopasar);
        } // en if
    }// end PasarArbolaCola

    // RECORRIDOS//
    public void PreOrder(NodoB nodo) {
        if (nodo != null) {
            System.out
                    .println("NumEmp: " + nodo.NumEmp + ", NomEmp: " + nodo.NomEmp + " ,Sueldo: " + nodo.Sueldo + "\n");
            PreOrder(nodo.LCHILD);
            PreOrder(nodo.RCHILD);
        }
    }// end PreOrder

    public void InOrder(NodoB nodo) {
        if (nodo != null) {
            InOrder(nodo.LCHILD);
            System.out
                    .println("NumEmp: " + nodo.NumEmp + ", NomEmp: " + nodo.NomEmp + " ,Sueldo: " + nodo.Sueldo + "\n");
            InOrder(nodo.RCHILD);
        }
    }// end InOrder

    public void PostOrder(NodoB nodo) {
        if (nodo != null) {
            PostOrder(nodo.LCHILD);
            PostOrder(nodo.RCHILD);
            System.out
                    .println("NumEmp: " + nodo.NumEmp + ", NomEmp: " + nodo.NomEmp + " ,Sueldo: " + nodo.Sueldo + "\n");
        }
    }// end PostOrder

    public void ImprimirLista() {
        if (!VaciaLista()) {
            temp = nc.next;
            while (temp != nc) {
                System.out
                        .println("NumEmp: " + temp.NumEmp + ", NomEmp: " + temp.NomEmp + " ,Sueldo: " + temp.Sueldo
                                + "\n");
                temp = temp.next;
            }
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end Imprimir Todo

    public void ImpimirCola() {
        if (!VaciaCola()) {
            System.out.println(cola.toString());
        } else {
            System.out.println("La cola esta vacia");
        } // end if
    }// end Imprimir Cola

    public void CantidadNodosLista() {
        int contador = 0;
        temp = nc.next;
        while (temp != nc) {
            contador++;
            temp = temp.next;
        } // end while
        System.out.println("La cantidad de nodos en la lista es de: " + contador);
    }// end Catidades Nodos Lista

    public int CantidadNodosArbol(NodoB nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int count = 0;
            count = 1;
            count += CantidadNodosArbol(nodo.LCHILD);
            count += CantidadNodosArbol(nodo.RCHILD);
            return count;
        } // end if else que lleva el conteo
    }// end CantidadNodos

    public int Profundidad(NodoB nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int leftDepth = Profundidad(nodo.LCHILD);
            int rightDepth = Profundidad(nodo.RCHILD);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            } // end if else que lleva el conteo
        } // end if else
    }// end Profundidad

    public void BorrarLista() {
        nc.next = nc;
    }// end BorrarLista
     // los puse separados porque sino se estaria borrando cadavez que vuelva a
     // iniciar el metodo PasasArbolLista, cuando quiera este, primero tengo 
     //que llamar BorrarLista y luego PasarArbolaLista

    public void PasarArbolaLista(NodoB nodo) {
        if (nodo != null) {
            PasarArbolaLista(nodo.LCHILD);
            AltaEnLista(nodo.NumEmp, nodo.NomEmp, nodo.Sueldo);
            PasarArbolaLista(nodo.RCHILD);
        } // en if
    }// end BorrarLista

    public void PasarListaaArbol() {
        temp=nc.next;
        while (temp!=nc) {
            AltaEnArbol(temp.NumEmp,temp.NomEmp, temp.Sueldo);
            temp=temp.next;
        }//end while
    }//end Pasar Lista a Arbol
}// end class
