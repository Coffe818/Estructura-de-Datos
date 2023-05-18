package Practica02;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ExameOrdinario {
    // pila y cola
    LinkedList<String> Cola = new LinkedList<String>();
    Stack<String> Pila = new Stack<String>();

    // les
    public class NodoL {
        String dato;
        NodoL next;

        public NodoL(String dato) {
            this.dato = dato;
        }// end constructor
    }// end class NODOL

    NodoL inicio;
    NodoL fin;
    NodoL ant;
    NodoL temp;
    NodoL NuevoNodoL;

    // clase nodo para el arbol binario
    class Nodo {
        Nodo Hijoizq;
        int dato;
        char estatus;
        Nodo Hijoder;

        public Nodo(int dato) {
            this.dato = dato;
            this.estatus = 'S';
            this.Hijoder = null;
            this.Hijoizq = null;
        }// end constructor del nodo

    }// end nodo

    static Nodo raiz;
    Nodo NuevoNodo;

    public void insertarVehiculo(String placa) {
        placa = placa.trim();// elimiana los espacios a la inicio y final de la palabra
        Pila.push(placa);
    }// end insertar Vehiculo

    public void eliminarVehiculo(String placa) {
        if (Pila.peek().equals(placa)) {
            Pila.pop();
        } else {
            while (!Pila.peek().equals(placa)) {
                Cola.add(Pila.pop());
            } // end while
            Pila.pop();
            while (!Cola.isEmpty()) {
                Pila.push(Cola.poll());
            } // end whila
        } // end if else
    }// end eliminarVehiculo

    public void imprimirVehiculos() {
        System.out.println(Pila.toString());
    }// end imprimir Vehiculos

    public void AgregarNodoArbol(int dato) {
        NuevoNodo = new Nodo(dato);

        if (raiz == null) {
            raiz = NuevoNodo;
        } else {
            Nodo actual = raiz;
            Nodo padre;
            while (true) {
                padre = actual;
                if (dato < actual.dato) {
                    actual = actual.Hijoizq;
                    if (actual == null) {
                        padre.Hijoizq = NuevoNodo;
                        return;
                    } // end if para agregar el nodo
                } else {
                    actual = actual.Hijoder;
                    if (actual == null) {
                        padre.Hijoder = NuevoNodo;
                        return;
                    } // end if para agregar el nodo
                } // end if para agregar el nodo ya sea derecha o izquierda
            } // end while para saber a donde dirigirse
        } // end if else de raiz
    }// end Agregar Nodo

    // RECORRIDOS//
    public void PreOrder(Nodo nodo) {
        if (nodo != null) {
            if (nodo.estatus != 'B') {
                System.out.println(nodo.dato);
            }
            PreOrder(nodo.Hijoizq);
            PreOrder(nodo.Hijoder);
        }
    }// end PreOrder

    public void InOrder(Nodo nodo) {
        if (nodo != null) {
            InOrder(nodo.Hijoizq);
            if (nodo.estatus != 'B') {
                System.out.println(nodo.dato);
            }
            InOrder(nodo.Hijoder);
        }
    }// end InOrder

    public void PostOrder(Nodo nodo) {
        if (nodo != null) {
            PostOrder(nodo.Hijoizq);
            PostOrder(nodo.Hijoder);
            if (nodo.estatus != 'B') {
                System.out.println(nodo.dato);
            }
        }
    }// end PostOrder

    public void BajaLogica(int dato) {
        Nodo actual = raiz;
        while (actual != null) {
            if (actual.dato == dato) {
                actual.dato = 'B';
                return;
            } else if (dato < actual.dato) {
                actual = actual.Hijoizq;
            } else {
                actual = actual.Hijoder;
            } // end if else que se recorre hasta encontrar el que queremos
        } // end while
    }// end Baja Logica

    public int CantidadNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int count = 0;
            if (nodo.estatus != 'B') {
                count = 1;
            }
            count += CantidadNodos(nodo.Hijoizq);
            count += CantidadNodos(nodo.Hijoder);
            return count;
        } // end if else que lleva el conteo
    }// end CantidadNodos

    public boolean Vacia() {
        return inicio == null;
    }// end vacia

    public void AltaEnLista(String dato) {
        NuevoNodoL = new NodoL(dato);
        if (!Vacia()) {
            fin.next = NuevoNodoL;
            fin = NuevoNodoL;
        } else {
            inicio = NuevoNodoL;
            fin = NuevoNodoL;
        } // end if else
    }// end Alta en la lista

    public void PasarArbolaLista(Nodo nodo) {
        if (nodo != null) {
            PasarArbolaLista(nodo.Hijoizq);
            String dato = String.valueOf(nodo.dato);
            AltaEnLista(dato);
            PasarArbolaLista(nodo.Hijoder);
        } // en if
    }// end BorrarLista

    public void ImprimirLESc() {
        if (!Vacia()) {
            temp = inicio;
            while (temp != null) {
                System.out.println(temp.dato);
                temp = temp.next;
            } // end while
        } else {
            System.out.println("La cola esta vacia");
        } // end if else
    }// end imprimir LES

    public void ImprimirPrimer() {
        if (!Vacia()) {
            temp = inicio;
            System.out.println(temp.dato);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end imprimir ultimo

    public void ImprimirUltimo() {
        if (!Vacia()) {
            temp = fin;
            System.out.println(temp.dato);
        } else {
            System.out.println("La lista esta vacia");
        } // end if else
    }// end imprimir ultimo

    public int TamanoPila() {
        return Pila.size();
    }// end numero Vehiculos

    public static void main(String[] args) {
        ExameOrdinario examen = new ExameOrdinario();
        Scanner s = new Scanner(System.in);
        String nombre = "18006022 Jose Manuel Grimaldo Valero";
        int opcion = 1;
        do {
            System.out.println("\n============ Menu Examen Ordinarios ==============\n" + nombre + "\n" +
                    "1.- Agregar auto a Pila \n" +
                    "2.- Eliminar un auto de Pila\n" +
                    "3.- Imprimir Pila\n" +
                    "4.- Agregar a Arbol Binario\n" +
                    "5.- Preorder\n" +
                    "6.- Inorder\n" +
                    "7.- Postorder\n" +
                    "8.- Eliminar auto de Arbol\n" +
                    "9.- Cantidad de nodos en Arbol\n" +
                    "10.- Pasar de Arbol a LESc\n" +
                    "11.- Imprimir LESc\n" +
                    "12.- Imprimir Primer elemento de LESc\n" +
                    "13.- Imprimir Ultimo elemento de LESc\n" +
                    "14.- Tamano de la Pila\n" +
                    "Seleccione una opcion: ");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Placa a agregar: ");
                    String placa = s.next();
                    examen.insertarVehiculo(placa);
                    System.out.println(nombre);
                    break;
                case 2:
                    System.out.println("Placa a eliminar: ");
                    placa = s.next();
                    examen.eliminarVehiculo(placa);
                    System.out.println(nombre);
                    break;
                case 3:
                    examen.imprimirVehiculos();
                    System.out.println(nombre);
                    break;
                case 4:
                    System.out.println("Agregar dato al Arbol");
                    int dato = s.nextInt();
                    examen.AgregarNodoArbol(dato);
                    System.out.println(nombre);
                    break;
                case 5:
                    System.out.println("Datos del arbol");
                    examen.PreOrder(raiz);
                    System.out.println(nombre);
                    break;
                case 6:
                    System.out.println("Datos del arbol");
                    examen.InOrder(raiz);
                    System.out.println(nombre);
                    break;
                case 7:
                    System.out.println("Datos del arbol");
                    examen.PostOrder(raiz);
                    System.out.println(nombre);
                    break;
                case 8:
                    System.out.println("Eliminar dato del Arbol");
                    dato = s.nextInt();
                    examen.BajaLogica(dato);
                    System.out.println(nombre);
                    break;
                case 9:
                    System.out.println("Cantidad de nodos en el arbol: " + examen.CantidadNodos(raiz));
                    System.out.println(nombre);
                    break;
                case 10:
                    examen.PasarArbolaLista(raiz);
                    System.out.println(nombre);
                    break;
                case 11:
                    System.out.println("Datos de la LESc");
                    examen.ImprimirLESc();
                    System.out.println(nombre);
                    break;
                case 12:
                    System.out.println("Primer dato de la LESc");
                    examen.ImprimirPrimer();
                    System.out.println(nombre);
                    break;
                case 13:
                    System.out.println("Ultimo dato de la LESc");
                    examen.ImprimirUltimo();
                    System.out.println(nombre);
                    break;
                case 14:
                    System.out.println("Tamano de la pila " + examen.TamanoPila());
                    System.out.println(nombre);
                    break;
                case 0:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
                    break;
            }// end switch

        } while (opcion != 0);

        s.close();
    }// end main

}// end class
