package Tareas;
 import java.util.LinkedList;
 import javax.swing.JOptionPane;
public class ColasDinamicas {
    static LinkedList <Integer> cola = new LinkedList<Integer>();
    
    private boolean Vacia() {
        return cola.isEmpty();
    }//end vacia

    private void Insertar( int elemento) {
        cola.add(elemento);
    }//end Insertar

    private void Eliminar() {
        if (!Vacia()) {
            int elemento =cola.poll();
            JOptionPane.showMessageDialog(null, "Se elimno el elemento: "+elemento);
        }else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        }//end if else
    }//end eliminar

    public void ImpimirCola() {
        if (!Vacia()) {
            JOptionPane.showMessageDialog(null, cola);
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        }//end if
    }//end Imprimir Cola

    public void PrimerElemento() {
        if (!Vacia()) {
            JOptionPane.showMessageDialog(null,"El primer elemento de la cola es: "+ cola.getFirst());
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        }//end if
    }//end Imprimir Primero

    public void UltimoElemento() {
        if (!Vacia()) {
            JOptionPane.showMessageDialog(null,"El ultimo elemento de la cola es: "+ cola.getLast());
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        }//end if
    }//end Imprimir Cola

    public void CantidadElementos() {
        JOptionPane.showMessageDialog(null, "La antidad e elemtnos de la cola es: "+ cola.size());
    }

    public static void main(String[] args) {
        ColasDinamicas cola = new ColasDinamicas();
        int opcion = 0;
        while (opcion != 7) {
            String menu = "Menú de opciones:\n" +
                    "1. Agregar elemento\n" +
                    "2. Eliminar elemento\n" +
                    "3. Ver elementos de la cola\n" +
                    "4. Imprimir el último elemento\n" +
                    "5. Imprimir el primer elemento\n" +
                    "6. Cantidad de elementos\n" +
                    "7. Salir\n" +
                    "Elige una opción: ";
            String input = JOptionPane.showInputDialog(menu);
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    String elemento = JOptionPane.showInputDialog("Ingrese el valor: ");
                    int xelemento = Integer.parseInt(elemento);
                    cola.Insertar(xelemento);
                    break;
                case 2:
                    cola.Eliminar();
                    break;
                case 3:
                    cola.ImpimirCola();
                    break;
                case 4:
                    cola.UltimoElemento();
                    break;
                case 5:
                    cola.PrimerElemento();
                    break;
                case 6:
                    cola.CantidadElementos();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
            }// end swhitch
        } // end while
    }// end main

}//ens class
