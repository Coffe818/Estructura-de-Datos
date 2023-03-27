package Tareas;

import javax.swing.JOptionPane;

public class RcursividadyNO {
    public static int FactorialRecursivo(int num) {
        if (num <= 1) {
            return 1;
        }//end if
        return num * FactorialRecursivo(num - 1);

    }// end Factorial

    public static int FacotrialNORecursivo(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }//end for
        return result;
    }// end Factorial

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Factorial Recursivo" +
                    "\n2. Factorial NO Recursivo" +
                    "\n0. Salir"));
            int num;
            switch (opcion) {
                case 1:

                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,"El numero factorial de " + num + " es: " + FactorialRecursivo(num));
                    break;
                case 2:

                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,"El numero factorial de " + num + " es: " + FacotrialNORecursivo(num));
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Saliendo");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Escoga una opcion valida");
                    break;
            }// end switch
        } while (opcion != 0);

    }// end main
}// end cass
