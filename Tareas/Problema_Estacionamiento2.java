package Tareas;

import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Problema_Estacionamiento2 {
    LinkedList<String> colaPrincipal;
    Stack<String> pilaTemporal;

    // contructor
    public Problema_Estacionamiento2() {
        colaPrincipal = new LinkedList<>();
        pilaTemporal = new Stack<>();
    }// end constructor

    private boolean Vacia() {
        return colaPrincipal.isEmpty();
    }// end vacia

    public void insertarVehiculo(String placa) {
        placa = placa.trim();// elimiana los espacios a la inicio y final de la palabra
        colaPrincipal.push(placa);
    }// end insertar Vehiculo

    public void eliminarVehiculo(String placa) {
        if (Vacia()) {
            JOptionPane.showInputDialog("La cola esta vacia");
        } else {
            if (colaPrincipal.peek().equals(placa)) {
                colaPrincipal.pop();
            } else {
                while (!colaPrincipal.peek().equals(placa)) {
                    pilaTemporal.push(colaPrincipal.pop());
                } // end while
                colaPrincipal.pop();
                while (!pilaTemporal.empty()) {
                    colaPrincipal.push(pilaTemporal.pop());
                } // end while
                JOptionPane.showMessageDialog(null, "Se eliminó el vehículo: " + placa);
            } // end if else
        } // end if else
    }// end elimiar placa


}// end class
