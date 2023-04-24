package Tareas;

public class ArbolesBinarios {
    class Nodo {
        Nodo Hijoizq;
        char estatus;
        int matricula;
        String nombre;
        Nodo Hijoder;
        
        public Nodo( int matricula, String nombre) {
            this.estatus='S';
            this.matricula=matricula;
            this.nombre=nombre;
        }// end constructor del nodo

    }//end nodo

    Nodo raiz;
    Nodo NuevoNodo;

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
                    }//end if para agregar el nodo
                } else {
                    actual = actual.Hijoder;
                    if (actual == null) {
                        padre.Hijoder = NuevoNodo;
                        return;
                    }//end if para agregar el nodo
                }//end if para agregar el nodo ya sea derecha o izquierda
            }//end while para saber a donde dirigirse
        }//end if else de raiz
    }//end Agregar Nodo

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
            }//end if else que se recorre hasta encontrar el que queremos
        }//end while
    }
}// end calss
