package Tareas;//tarea 5
import java.util.Stack;
import javax.swing.JOptionPane;

public class Problema_Estacionamiento {
    Stack<String> pilaPrincipal;
    Stack<String> pilaTemporal;
    // contructor
    public Problema_Estacionamiento() {
        pilaPrincipal = new Stack<>();
        pilaTemporal = new Stack<>();
    }//end constructor

    public void insertarVehiculo(String placa) {
        placa = placa.trim();// elimiana los espacios a la inicio y final de la palabra
        pilaPrincipal.push(placa);
    }// end insertar Vehiculo

    public void eliminarVehiculo(String placa) {
        if (pilaPrincipal.peek().equals(placa)) {
            pilaPrincipal.pop();
        } else {
            while (!pilaPrincipal.peek().equals(placa)) {
                pilaTemporal.push(pilaPrincipal.pop());
            }// end while
            pilaPrincipal.pop();
            while (!pilaTemporal.empty()) {
                pilaPrincipal.push(pilaTemporal.pop());
            }// end while
            JOptionPane.showMessageDialog(null, "Se eliminó el vehículo: " + placa);
        }// end if else
    }// end elimiar placa

    public Stack<String> imprimirVehiculos() {
        return pilaPrincipal;
    }// end imprimir Vehiculos

    public int numeroVehiculos() {
        return pilaPrincipal.size();
    }// end numero Vehiculos

    public String ultimoVehiculo() {
        return pilaPrincipal.peek();
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
                    
                    pila.eliminarVehiculo(JOptionPane.showInputDialog("Placas disponibles para eliminar:\n"+ pila.imprimirVehiculos()));
                    break;
                
                case 3:
                  JOptionPane.showMessageDialog( null, pila.imprimirVehiculos());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Número de vehiculos en el estacionamiento: "+ pila.numeroVehiculos());
                 
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
