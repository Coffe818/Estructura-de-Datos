package Tareas;
 import java.util.LinkedList;
public class ColasDinamicas {
    static LinkedList <Integer> cola = new LinkedList<Integer>();
    
    private boolean Vacia() {
        return cola.isEmpty();
    }

    private void Insertar( int x) {
        cola.add(x);
    }
}//ens class
