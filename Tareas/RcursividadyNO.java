package Tareas;

import javax.swing.JOptionPane;

public class RcursividadyNO {
    public static int FactorialRecursivo(int num) {
        if (num <= 1) {
            return 1;
        } // end if
        return num * FactorialRecursivo(num - 1);

    }// end Factorial

    public static int FacotrialNORecursivo(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        } // end for
        return result;
    }// end Factorial NO recursivo

    public static int FibnacciRecursico(int num) {
        if (num == 0) {
            return 0;
        } // end it
        if (num == 1) {
            return 1;
        } // end if
        return FibnacciRecursico(num - 1) + FibnacciRecursico(num - 2);
    }// end Fibonacci recursivo

    public static int FibonacciNORecursivo(int num) {
        if (num == 1) {
            return 1;
        } // end if
        int a = 0;
        int b = 1;
        for (int i = 2; i <= num; i++) {
            int c = a + b;
            a = b;
            b = c;
        } // end for
        return b;
    }// end Fibonacci NO recursivo

    public static int SeparaSumaNORecursivo(int num) {
        int suma = 0;
        while (num != 0) {
            int digito = num % 10;
            suma += digito;
            num /= 10;
        } // end while
        return suma;
    }// end separa los digitos y los suma No Recursivo

    public static int SeparaSumaRecursivo(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + SeparaSumaRecursivo(num / 10);
    }// end separa los digitos y los suma Recursivo

    /* Ejemplo de como funciona 
     * SeparaSumaRecursivo(235)
     * 5 + SeparaSumaRecursivo(23)
     * 5 + (3 + SeparaSumaRecursivo(2))
     * 5 + (3 + 2)
     * 10 
     */

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "======MENU RECURSIVIDAD====" +
                    "\n1. Factorial Recursivo" +
                    "\n2. Factorial NO Recursivo" +
                    "\n3. Fibonacci Recursivo" +
                    "\n4. Fibonacci NO Recursivo" +
                    "\n5. Separa los numeros y los suma Recursivo" +
                    "\n6. Separa los numeros y los suma NO Recursivo" +
                    "\n0. Salir"));
            int num;
            switch (opcion) {
                case 1:
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,
                            "El numero factorial de " + num + " es: " + FactorialRecursivo(num));
                    break;
                case 2:
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,
                            "El numero factorial de " + num + " es: " + FacotrialNORecursivo(num));
                    break;
                case 3:
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,
                            "El numero fibonacci de " + num + " es: " + FibnacciRecursico(num));
                    break;
                case 4:
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,
                            "El numero fibonacci de " + num + " es: " + FibonacciNORecursivo(num));
                    break;
                case 5:
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,
                            "La suma de los digitos del " + num + " es de : " + SeparaSumaRecursivo(num));
                    break;
                case 6:
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero: "));
                    JOptionPane.showMessageDialog(null,
                            "La suma de los digitos del " + num + " es de : " + SeparaSumaNORecursivo(num));
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Escoga una opcion valida");
                    break;
            }// end switch
        } while (opcion != 0);

    }// end main
}// end cass
