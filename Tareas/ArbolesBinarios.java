package Tareas;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArbolesBinarios {
    class Nodo {
        Nodo Hijoizq;
        char estatus;
        int matricula;
        String nombre;
        Nodo Hijoder;

        public Nodo(int matricula, String nombre) {
            this.estatus = 'S';
            this.matricula = matricula;
            this.nombre = nombre;
            this.Hijoder = null;
            this.Hijoizq = null;
        }// end constructor del nodo

    }// end nodo

    static Nodo raiz;
    Nodo NuevoNodo;
    DefaultTableModel modelo = new DefaultTableModel();// aqui agrego los datos
    JTable tabla = new JTable();// aqui se agregan a la tabla
    JScrollPane scrollPane = new JScrollPane();// en cso de que sea muy grande y necesite parras de desplasamiento

    public void NombreColumnas() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Matricula");
        modelo.addColumn("Nombre");
    }// end Nombre columnas

    public void AgregarDatos(int matricula, String nombre) {
        Object[] fila = { matricula, nombre };
        modelo.addRow(fila);
    }// end agregar datos

    public void ImprimirTabla() {
        tabla = new JTable(modelo);
        scrollPane = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(null, scrollPane);
    }// end imprimirTabla

    public void AgregarNodo(int matricula, String nombre) {
        NuevoNodo = new Nodo(matricula, nombre);

        if (raiz == null) {
            raiz = NuevoNodo;
        } else {
            Nodo actual = raiz;
            Nodo padre;
            while (true) {
                padre = actual;
                if (matricula < actual.matricula) {
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

    public void BajaLogica(int matricula) {
        Nodo actual = raiz;
        while (actual != null) {
            if (actual.matricula == matricula) {
                actual.estatus = 'B';
                return;
            } else if (matricula < actual.matricula) {
                actual = actual.Hijoizq;
            } else {
                actual = actual.Hijoder;
            } // end if else que se recorre hasta encontrar el que queremos
        } // end while
    }// end Baja Logica

    private Nodo ObtenerSucesor(Nodo actual) {
        while (actual.Hijoizq != null) {
            actual = actual.Hijoizq;
        } // while para posicionar
        return actual;
    }// end Obtener Sucesor

    private Nodo Eliminar(Nodo actual, int matricula) {// donde inicia , que matricula eliminar
        if (actual == null) {
            return null;
        }

        if (matricula == actual.matricula) {
            if (actual.Hijoizq == null) {
                return actual.Hijoder;
            } else if (actual.Hijoder == null) {
                return actual.Hijoizq;
            } else {
                Nodo sucesor = ObtenerSucesor(actual.Hijoder);
                actual.matricula = sucesor.matricula;
                actual.nombre = sucesor.nombre;
                actual.Hijoder = Eliminar(actual.Hijoder, sucesor.matricula);
                return actual;
            } // regresa actual que queremos eliminar
        } else if (matricula < actual.matricula) {
            actual.Hijoizq = Eliminar(actual.Hijoizq, matricula);
            return actual;
        } else {
            actual.Hijoder = Eliminar(actual.Hijoder, matricula);
            return actual;
        } // recursividad hasta encontrar el nodo que queremos eliminar
    }// end Eliminar

    public void BajaFisica(int matricula) {
        raiz = Eliminar(raiz, matricula);
    }// Baja Fisica

    // RECORRIDOS//
    public void PreOrder(Nodo nodo) {
        if (nodo != null) {
            if (nodo.estatus != 'B') {
                AgregarDatos(nodo.matricula, nodo.nombre);
            } // end if para agregar datos
            PreOrder(nodo.Hijoizq);
            PreOrder(nodo.Hijoder);
        }
    }// end PreOrder

    public void InOrder(Nodo nodo) {
        if (nodo != null) {
            InOrder(nodo.Hijoizq);
            if (nodo.estatus != 'B') {
                AgregarDatos(nodo.matricula, nodo.nombre);
            } // end if para agregar datos
            InOrder(nodo.Hijoder);
        }
    }// end InOrder

    public void PostOrder(Nodo nodo) {
        if (nodo != null) {
            PostOrder(nodo.Hijoizq);
            PostOrder(nodo.Hijoder);
            if (nodo.estatus != 'B') {
                AgregarDatos(nodo.matricula, nodo.nombre);
            } // end if para agregar datos
        }
    }// end PostOrder
     // metodos para imprimir

    public void ImprimirPreOrder() {
        NombreColumnas();
        PreOrder(raiz);
        ImprimirTabla();
    }// end ImprimirPreOrder

    public void ImprimirInOrder() {
        NombreColumnas();
        InOrder(raiz);
        ImprimirTabla();
    }// end ImprimirInOrder

    public void ImprimirPostOrder() {
        NombreColumnas();
        PostOrder(raiz);
        ImprimirTabla();
    }// end ImprimirPostOrder

    public int Profundidad(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int leftDepth = Profundidad(nodo.Hijoizq);
            int rightDepth = Profundidad(nodo.Hijoder);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            } // end if else que lleva el conteo
        } // end if else
    }// end Profundidad

    public void Raiz() {
        if (raiz != null) {
            JOptionPane.showMessageDialog(null, "Matrícula: " + raiz.matricula +
                    "\nNombre: " + raiz.nombre + "\nEstatus: " + raiz.estatus);
        } // end if
    }// end Raiz

    public int CantidadNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int count = 1;
            count += CantidadNodos(nodo.Hijoizq);
            count += CantidadNodos(nodo.Hijoder);
            return count;
        } // end if else que lleva el conteo
    }// end CantidadNodos

    public static void main(String[] args) {
        ArbolesBinarios Arbol = new ArbolesBinarios();
        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU ARBOL BINARIO ======\n"
                    + "1. Alta de elemento\n"
                    + "2. Baja Logica de elemento\n"
                    + "3. Baja fisica\n"
                    + "4. Recorrido PREORDER \n"
                    + "5. Recorrido INORDER\n"
                    + "6. Recorrido POSTORDER\n"
                    + "7. Profundidad\n"
                    + "8. Imprimir Nodo Raiz\n"
                    + "9. Cantidad de Nodos\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese matricula: "));
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre: ");
                    Arbol.AgregarNodo(matricula, nombre);
                    break;
                case 2:
                    matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese matricula: "));
                    Arbol.BajaLogica(matricula);
                    break;
                case 3:
                    matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese matricula: "));
                    Arbol.BajaFisica(matricula);
                    break;
                case 4:
                    Arbol.ImprimirPreOrder();
                    break;
                case 5:
                    Arbol.ImprimirInOrder();
                    break;
                case 6:
                    Arbol.ImprimirPostOrder();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, Arbol.Profundidad(raiz));
                    break;
                case 8:
                    Arbol.Raiz();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, Arbol.CantidadNodos(raiz));
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }// end switch
            System.out.println();
        } while (opcion != 0);
    }// end main
}// end calss
