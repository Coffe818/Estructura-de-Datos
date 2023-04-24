package Tareas;

public class ArbolesBinarios {
    class Nodo {
        Nodo Hijoizq;
        char estatus;
        int matricula;
        String nombre;
        Nodo Hijoder;
        
        public Nodo(char estatus, int matricula, String nombre) {
            this.estatus=estatus;
            this.matricula=matricula;
            this.nombre=nombre;
        }// end constructor del nodo

    }//end nodo

    Nodo raiz;
    Nodo NuevoNodo;
    public void AgregarNodo(int matricula, String nombre, char estatus) {
        NuevoNodo = new Nodo( estatus, matricula, nombre);

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
    
}// end calss
