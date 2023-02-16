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
        colaPrincipal.add(placa);
    }// end insertar Vehiculo

    public void eliminarVehiculo(String placa) {
        if (Vacia()) {
            JOptionPane.showInputDialog("La cola esta vacia");
        } else {
            if (colaPrincipal.getLast().equals(placa)) {
                colaPrincipal.poll();
            } else {
                while (!colaPrincipal.getFirst().equals(placa)) {
                    pilaTemporal.push(colaPrincipal.poll());
                } // end while
                colaPrincipal.poll();
                while (!pilaTemporal.isEmpty()) {
                    colaPrincipal.add(pilaTemporal.pop());
                } // end while
                JOptionPane.showMessageDialog(null, "Se eliminó el vehículo: " + placa);
            } // end if else
        } // end if else
    }// end elimiar placa

    public LinkedList<String> imprimirVehiculos() {
            return colaPrincipal;
    }// end imprimir Vehiculos

    public int numeroVehiculos() {
        return colaPrincipal.size();
    }// end numero Vehiculos

    public String ultimoVehiculo() {
        return colaPrincipal.getLast();
    }// end ultimo vehiculo

    public Stack<String> ImprimirPila() {        
            return pilaTemporal;
    }//end imprimir pila

    public static void main(String[] args) {
        int opcion = 0;
        Problema_Estacionamiento2 cola = new Problema_Estacionamiento2();

        while (opcion !=7 ) {
            String menu = "1. Insertar vehículo\n" +
                    "2. Eliminar vehículo\n" +
                    "3. Imprimir vehículos\n" +
                    "4. Número de vehículos\n" +
                    "5. Ultimo vehículo insertado\n" +
                    "6. Mostrar pila\n"+
                    "7. Salir\n" +
                    "Seleccione una opción: ";
            String opcionString = JOptionPane.showInputDialog(menu);
            opcion = Integer.parseInt(opcionString);

            switch (opcion) {
                case 1:
                cola.insertarVehiculo(JOptionPane.showInputDialog("Ingrese la placa del vehículo:"));
                    break;
                case 2:
                cola.eliminarVehiculo(JOptionPane.showInputDialog(null,"Placas disponibles para eliminar:\n" + cola.imprimirVehiculos() ));
                    break;
                case 3:
                if (cola.Vacia()) {
                    JOptionPane.showMessageDialog(null, "La pila esta vacia");
                } else {
                    JOptionPane.showMessageDialog(null,  cola.imprimirVehiculos());
                }//end if else                    
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Número de vehiculos en el estacionamiento: " + cola.numeroVehiculos());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Ultimo vehículo insertado: " + cola.ultimoVehiculo());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,"Vehiculos en pila temporal: " + cola.ImprimirPila());                          
                break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Hasta luego");
            }// end switcH 
        } // end while
    }// end main

}// end class
