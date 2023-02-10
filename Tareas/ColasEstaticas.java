package Tareas;

import javax.swing.JOptionPane;

public class ColasEstaticas {
    int max = 50;
    int cola[] = new int[max];
    int inicio = 0, fin = 0, cantidad =0;
    

    public boolean Vacia() {
        return inicio == fin; 
    }// end vacia

    public boolean Llena() {
        return fin == inicio;
    }// end llena

    public void Insertar(int elemento) {
        int temp = fin;
        fin = (fin + 1) % max;
        if (!Llena()) {
            cola[fin] = elemento;
        } else {
            fin = temp;
            JOptionPane.showMessageDialog(null, "La cola esta llena");

        } // end if else
    }// end Insertar

    public void Eliminar() {
        if (!Vacia()) {
            inicio = (inicio + 1) % max;
            int elemento = cola[inicio];
            JOptionPane.showMessageDialog(null, "Elemento " + elemento + " borrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacía");
        } // end if else
    }// end Eliminar

    public void ImpimirCola() {
        if (!Vacia()) {
            int i=inicio;
            String elementos = "";

            while (i != fin) {
                i = (i + 1) % max;
                elementos += "[" + cola[i] + "]";
            } // end while
            JOptionPane.showMessageDialog(null, "Estos son los elementos de la Cola: " + elementos);

        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } // end if else
    }// end Imprimir cola

    public void UltimoElemento() {
        if (!Vacia()) {
            JOptionPane.showMessageDialog(null, "El ultimo elemento es: " + cola[fin]);

        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");

        } // end if else
    }// ent ultimo Elemento

    public void PrimerElemento() {
        if (!Vacia()) {
            int x = (inicio + 1) % max;
            JOptionPane.showMessageDialog(null, "El primer elemento es: " + cola[x]);

        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");

        } // end if else
    }// end Primer Elemento

    public void CantidadElementos() {
        if (!Vacia()) {
            JOptionPane.showMessageDialog(null, "En la cola existen " + "x" + " de elementos");
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");

        }
    }// end Cantidad Elementos

    public static void main(String[] args) {
        ColasEstaticas cola = new ColasEstaticas();
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
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
            }// end swhitch
        } // end while
    }// end main

}// end class
