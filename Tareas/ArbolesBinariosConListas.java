package Tareas;

import java.util.LinkedList;
import java.util.Scanner;

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

    static NodoB raiz;
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
    public boolean BuscarNodo(int numEmp) {
        NodoB actual = raiz;
        while (actual != null) {
            if (actual.NumEmp == numEmp) {
                return true; // se encontró un nodo con el mismo número de empleado
            } else if (numEmp < actual.NumEmp) {
                actual = actual.LCHILD;
            } else {
                actual = actual.RCHILD;
            }
        }//end while para ir recorriendo actual
        return false; // no se encontró ningún nodo con el mismo número de empleado
    }// end Buscar Nodo

    public void AltaEnArbol(int numEmp, String nombre, float sueldo) {
        if (BuscarNodo(numEmp)) {
            System.out.println("El número de empleado ya existe en el árbol.");
            return;
        }//end if para saber si se repite o no
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

    public void PasarArbolaCola(NodoB nodo) {
        if (nodo != null) {
            PasarArbolaCola(nodo.LCHILD);
            cola.add(nodo.NumEmp);
            PasarArbolaCola(nodo.RCHILD);
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
     // que llamar BorrarLista y luego PasarArbolaLista

    public void PasarArbolaLista(NodoB nodo) {
        if (nodo != null) {
            PasarArbolaLista(nodo.LCHILD);
            AltaEnLista(nodo.NumEmp, nodo.NomEmp, nodo.Sueldo);
            PasarArbolaLista(nodo.RCHILD);
        } // en if
    }// end BorrarLista

    public void PasarListaaArbol() {
        temp = nc.next;
        while (temp != nc) {
            AltaEnArbol(temp.NumEmp, temp.NomEmp, temp.Sueldo);
            temp = temp.next;
        } // end while
    }// end Pasar Lista a Arbol

    public static void main(String[] args) {
        ArbolesBinariosConListas arbol = new ArbolesBinariosConListas();
        Scanner s = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("=============Menu Arbol Binario con listas==================\n"
                    + "1. Alta de elemento en el arbol\n"
                    + "2. Alta de elemento en lista encadenada circular\n"
                    + "3. Pasar todos los NumEmp del arbol a la cola\n"
                    + "4. Recorrido PREORDER \n"
                    + "5. Recorrido INORDER\n"
                    + "6. Recorrido POSTORDER\n"
                    + "7. Imprimir lista encadenada circular\n"
                    + "8. Imprimir Cola\n"
                    + "9. Cantidad de Nodos en la lista encadenada simple circular\n"
                    + "10. Cantidad de Nodos en el arbol binario\n"
                    + "11. Proundidad del arbol\n"
                    + "12. Borrar lista y pasar los datos del arbol a la lista\n"
                    + "13. Pasar de la lista al arbol\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Numero de empleado: ");
                    int numemp = s.nextInt();
                    System.out.println("Sueldo de empleado: ");
                    Float sueldo = s.nextFloat();
                    s.nextLine();
                    System.out.println("Nombre de empleado: ");
                    String nomemp = s.nextLine();

                    arbol.AltaEnArbol(numemp, nomemp, sueldo);
                    break;
                case 2:
                    System.out.println("Numero de empleado: ");
                    numemp = s.nextInt();
                    System.out.println("Sueldo de empleado: ");
                    sueldo = s.nextFloat();
                    s.nextLine();
                    System.out.println("Nombre de empleado: ");
                    nomemp = s.nextLine();

                    arbol.AltaEnLista(numemp, nomemp, numemp);
                    break;
                case 3:
                    arbol.PasarArbolaCola(raiz);
                    break;
                case 4:
                    arbol.PreOrder(raiz);
                    break;
                case 5:
                    arbol.InOrder(raiz);
                    break;
                case 6:
                    arbol.PostOrder(raiz);
                    break;
                case 7:
                    arbol.ImprimirLista();
                    break;
                case 8:
                    arbol.ImpimirCola();
                    break;
                case 9:
                    arbol.CantidadNodosLista();
                    break;
                case 10:
                    System.out.println("La cantidad de nodos en el arbol: " + arbol.CantidadNodosArbol(raiz));
                    break;
                case 11:
                    System.out.println("La profundidad del arbo: " + arbol.Profundidad(raiz));
                    break;
                case 12:
                    arbol.BorrarLista();
                    arbol.PasarArbolaLista(raiz);
                    break;
                case 13:
                    arbol.PasarListaaArbol();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Seleccione opcion valida");
                    break;
            }// end switch

        } while (opcion != 0);

        s.close();
    }// end main
}// end class
