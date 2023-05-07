package Practica02;
//Jose Manuel Grimaldo Valero
// Utilize Scanner para imprimir y leer datos
import java.util.LinkedList;
import java.util.Scanner;

public class ExamenParcial2 {
    // class nodo para el arbol
    public class NodoAb {
        int numart;
        String nomart;
        int existencia;
        char estatus;
        NodoAb izq;
        NodoAb der;

        public NodoAb(int numart, String nomart, int existencia) {
            this.numart = numart;
            this.nomart = nomart;
            this.existencia = existencia;
            this.estatus = 's';

        }// end costructor
    }// end NodoAb

    static NodoAb raiz;
    NodoAb NuevoNodoAb;

    // class noso para la lista encadenada simple
    public class NodoLes {
        int numart;
        String nomart;
        int existencia;
        NodoLes next;

        public NodoLes(int numart, String nomart, int existencia) {
            this.numart = numart;
            this.nomart = nomart;
            this.existencia = existencia;
        }// end costructor
    }// end NodoLes

    NodoLes first;
    NodoLes ant;
    NodoLes temp;
    NodoLes NuevoNodoLes;
    // crea cola
    LinkedList<Integer> cola = new LinkedList<Integer>();

    public boolean BuscarNodo(int numart) {
        NodoAb actual = raiz;
        while (actual != null) {
            if (actual.numart == numart) {
                return true; // se encontró un nodo con el mismo numart
            } else if (numart < actual.numart) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        } // end while para ir recorriendo actual
        return false; // no se encontró ningún nodo con el mismo numart
    }// end Buscar Nodo

    public void AltaEnArbol(int numart, String nomart, int existencia) {
        if (BuscarNodo(numart)) {
            System.out.println("El número de empleado ya existe en el árbol.");
            return;
        } // end if para saber si se repite o no
        NuevoNodoAb = new NodoAb(numart, nomart, existencia);
        if (raiz == null) {
            raiz = NuevoNodoAb;
        } else {
            NodoAb actual = raiz;
            NodoAb padre;
            while (true) {
                padre = actual;
                if (numart < actual.numart) {
                    actual = actual.izq;
                    if (actual == null) {
                        padre.izq = NuevoNodoAb;
                        return;
                    } // end if para agregar el nodo
                } else {
                    actual = actual.der;
                    if (actual == null) {
                        padre.der = NuevoNodoAb;
                        return;
                    } // end if para agregar el nodo
                } // end if para agregar el nodo ya sea derecha o izquierda
            } // end while para saber a donde dirigirse
        } // end if else de raiz
    }// end Agregar Nodo o alta de un nodo en el arbol

    public void BajaLogica(int numart) {
        NodoAb actual = raiz;
        while (actual != null) {
            if (actual.numart == numart) {
                actual.estatus = 'B';
                return;
            } else if (numart < actual.numart) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            } // end if else que se recorre hasta encontrar el que queremos
        } // end while
    }// end Baja Logica

    public void AltaEnLista(int numart, String nomart, int existencia) {
        NuevoNodoLes = new NodoLes(numart, nomart, existencia);
        if (first == null) {
            first = NuevoNodoLes;
        } else {
            ant = null;
            temp = first;

            while (temp != null && temp.numart >= numart) {// Recore ant y temp
                                                           // hasta que se acomode
                                                           // por numart
                ant = temp;
                temp = temp.next;
            } // end while para numart

            if (ant == null) {
                first = NuevoNodoLes;
            } else {
                ant.next = NuevoNodoLes;
            } // end if else que agrega los datos
            NuevoNodoLes.next = temp;
        } // end if else que contirne los while
    }// end AltaEnLista

    public void PasarArbolaLes(NodoAb nodo) {
        if (nodo != null) {
            PasarArbolaLes(nodo.izq);
            if (nodo.estatus != 'B') {
                AltaEnLista(nodo.numart, nodo.nomart, nodo.existencia);
            }
            PasarArbolaLes(nodo.der);
        } // en if
    }// end PasarArbolaLes
     // RECORRIDOS EL

    public void PreOrder(NodoAb nodo) {
        if (nodo != null) {
            if (nodo.estatus != 'B') {
                System.out
                        .println("NumArt: " + nodo.numart + ", NomAr: " + nodo.nomart + " ,Existencia: "
                                + nodo.existencia
                                + "\n");
            }
            PreOrder(nodo.izq);
            PreOrder(nodo.der);
        }
    }// end PreOrder

    public void InOrder(NodoAb nodo) {
        if (nodo != null) {
            InOrder(nodo.izq);
            if (nodo.estatus != 'B') {
                System.out
                        .println("NumArt: " + nodo.numart + ", NomAr: " + nodo.nomart + " ,Existencia: "
                                + nodo.existencia
                                + "\n");
            }
            InOrder(nodo.der);
        }
    }// end InOrder

    public void PostOrder(NodoAb nodo) {
        if (nodo != null) {
            PostOrder(nodo.izq);
            PostOrder(nodo.der);
            if (nodo.estatus != 'B') {
                System.out
                        .println("NumArt: " + nodo.numart + ", NomAr: " + nodo.nomart + " ,Existencia: "
                                + nodo.existencia
                                + "\n");
            }
        }
    }// end PostOrder

    public void BuscarNodoImprimir(int numart) {
        NodoAb actual = raiz;
        while (actual != null) {
            if (actual.numart == numart) {
                System.out
                        .println("NumArt: " + actual.numart + ", NomAr: " + actual.nomart + " ,Existencia: "
                                + actual.existencia + "\n");
                return;
                // se encontró un nodo con el mismo numart
            } else if (numart < actual.numart) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        } // end while para ir recorriendo actual

    }// end Buscar Nodo

    public int CantidadNodos(NodoAb nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int count = 0;
            if (nodo.estatus != 'B') {
                count = 1;
            }
            count += CantidadNodos(nodo.izq);
            count += CantidadNodos(nodo.der);
            return count;
        } // end if else que lleva el conteo
    }// end CantidadNodos

    public int Profundidad(NodoAb nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int leftDepth = Profundidad(nodo.izq);
            int rightDepth = Profundidad(nodo.der);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            } // end if else que lleva el conteo
        } // end if else
    }// end Profundidad

    public void PasarArbolaCola(NodoAb nodo) {
        if (nodo != null) {
            PasarArbolaCola(nodo.izq);
            if (nodo.estatus != 'B') {
                cola.add(nodo.numart);
            }
            PasarArbolaCola(nodo.der);
        } // en if
    }// end PasarArbolaCola

    public boolean Vacia() {
        return first == null;
    }// end Vacia

    public void ImprimirLes() {
        if (!Vacia()) {
            temp = first;

            while (temp != null) {
                System.out
                        .println("NumArt: " + temp.numart + ", NomAr: " + temp.nomart + " ,Existencia: "
                                + temp.existencia
                                + "\n");
                temp = temp.next;
            } // end while para imprimir

        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// en imprimir todo

    private boolean VaciaCola() {
        return cola.isEmpty();
    }// end vacia

    public void ImpimirCola() {
        if (!VaciaCola()) {
            System.out.println(cola.toString());
        } else {
            System.out.println("La cola esta vacia");
        } // end if
    }// end Imprimir Cola

    public static void main(String[] args) {
        ExamenParcial2 examen = new ExamenParcial2();
        Scanner s = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("=============Menu Examen Parcial U2==================\n"
                    + "1. Alta de elemento en el arbol\n"
                    + "2. Baja Logica\n"
                    + "3. Pasar todo el Arbol a LES\n"
                    + "4. Recorrido PREORDER \n"
                    + "5. Recorrido INORDER\n"
                    + "6. Recorrido POSTORDER\n"
                    + "7. Buscar Nodo en Arbol\n"
                    + "8. Cantidad de nodos\n"
                    + "9. Proundidad del arbol\n"
                    + "10. Pasar del arbol a la Cola\n"
                    + "11. Imprimir LEs\n"
                    + "12. Imprimir Cola\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Numero de articulo: ");
                    int numart = s.nextInt();
                    System.out.println("Esistencia: ");
                    int existencia = s.nextInt();
                    s.nextLine();
                    System.out.println("Nombre del Articulo: ");
                    String nomart = s.nextLine();
                    examen.AltaEnArbol(numart, nomart, existencia);
                    break;
                case 2:
                    System.out.println("Numero de articulo: ");
                    numart = s.nextInt();
                    examen.BajaLogica(numart);
                    break;
                case 3:
                    examen.PasarArbolaLes(raiz);
                    break;
                case 4:
                    examen.PreOrder(raiz);
                    break;
                case 5:
                    examen.InOrder(raiz);
                    break;
                case 6:
                    examen.PostOrder(raiz);
                    break;
                case 7:
                    System.out.println("Numero de articulo: ");
                    numart = s.nextInt();
                    examen.BuscarNodoImprimir(numart);
                    break;
                case 8:
                    System.out.println("La cantidad de nodos en el arbol: " + examen.CantidadNodos(raiz));
                    break;
                case 9:
                    System.out.println("La profundidad del arbo: " + examen.Profundidad(raiz));
                    break;
                case 10:
                    examen.PasarArbolaCola(raiz);
                    break;
                case 11:
                    examen.ImprimirLes();
                    break;
                case 12:
                    examen.ImpimirCola();
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
