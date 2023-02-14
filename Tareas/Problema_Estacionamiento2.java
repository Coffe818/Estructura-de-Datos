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

    public void imprimirVehiculos() {
        if (Vacia()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            JOptionPane.showMessageDialog(null, colaPrincipal);
        }

    }// end imprimir Vehiculos

    public int numeroVehiculos() {
        return colaPrincipal.size();
    }// end numero Vehiculos

    public String ultimoVehiculo() {
        return colaPrincipal.peek();
    }// end ultimo vehiculo

    public static void main(String[] args) {
        int opcion = 0;
        Problema_Estacionamiento pila = new Problema_Estacionamiento();

        while (opcion != 6) {
            String menu = "1. Insertar vehículo\n" +
                    "2. Eliminar vehículo\n" +
                    "3. Imprimir vehículos\n" +
                    "4. Número de vehículos\n" +
                    "5. Ultimo vehículo insertado\n" +
                    "6. Salir\n" +
                    "Seleccione una opción: ";
            String opcionString = JOptionPane.showInputDialog(menu);
            opcion = Integer.parseInt(opcionString);

            switch (opcion) {
                case 1:

                    pila.insertarVehiculo(JOptionPane.showInputDialog("Ingrese la placa del vehículo:"));
                    break;
                case 2:
                    pila.eliminarVehiculo(JOptionPane.showInputDialog("Placas disponibles para eliminar:\n" + pila.imprimirVehiculos()));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, pila.imprimirVehiculos());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Número de vehiculos en el estacionamiento: " + pila.numeroVehiculos());

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Ultimo vehículo insertado: " + pila.ultimoVehiculo());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Hasta luego");
            }// end switcH
        } // end while
    }// end main

}// end class
