package Tareas;//tarea 2

import java.util.Scanner;

public class Arreglo_Bidimensional {
    static private int[][] ArregloA, ArregloB, ArregloC;
    static int M, N, R, C;// M renglones, N columnas

    static String Line = "----------------------------------------------------";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Cuantos renglones? ");
        N = s.nextInt();
        System.out.println("Cuantas columnas? ");
        M = s.nextInt();

        Arreglo_Bidimensional Ab = new Arreglo_Bidimensional(M, N);
        System.out.println("\nEl arreglo A: ");
        Ab.ArregloA();
        System.out.println(Line + "\nEl arreglo B:");
        Ab.ArregloB();
        System.out.println(Line + "\nEl arreglo C sumando A+B:");
        Ab.ArregloC1();
        System.out.println(Line + "\nEl arreglo C restando A-B:");
        Ab.ArregloC2();
        System.out.println(Line + "\nEl arreglo C multimplicando A*B:");
        Ab.ArregloC3();
        System.out.println(Line + "\nEl promedio por renglon de A es: ");
        Ab.PromedioA();
        System.out.println(Line + "\nEl promedio por renglon de B es:");
        Ab.PromedioB();
        System.out.println(Line + "\n EL arrego A siendo clonado al arreglo C:");
        Ab.ClonarC();

        s.close();
    }// end main

    // constructor
    public Arreglo_Bidimensional(int M, int N) {
        R = M;
        C = N;
        ArregloA = new int[C][R];
        ArregloB = new int[C][R];
        ArregloC = new int[C][R];
    }// end constructor

    // Metodos
    public void LlenarArreglo(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                int numero = (int) (Math.random() * 100 + 1);
                x[i][j] = numero;
            } // end for
        } // end for
    }// end llenar arreglo

    public void ImprimirArreglo(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print("[" + x[i][j] + "]");
            } // end for
            System.out.println();
        } // end for
    }// end imprimir arreglo

    public void CrearArregloC(int[][] x, int[][] array1, int[][] array2, int operador) {

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                switch (operador) {
                    case 1:// suma
                        x[i][j] = array1[i][j] + array2[i][j];
                        break;
                    case 2:// resta
                        x[i][j] = array1[i][j] - array2[i][j];
                        break;
                    case 3:// multiplicacion
                        x[i][j] = array1[i][j] * array2[i][j];
                        break;

                    default:
                        break;
                }//end switch
            } // end for
        } // end for
    }// end Crear Arreglo C

    public void ArregloA() {
        LlenarArreglo(ArregloA);
        ImprimirArreglo(ArregloA);
    }// end Arreglo A

    public void ArregloB() {
        LlenarArreglo(ArregloB);
        ImprimirArreglo(ArregloB);
    }// end Arreglo B

    public void ArregloC1() {
        CrearArregloC(ArregloC, ArregloB, ArregloA, 1);// sumandose
        ImprimirArreglo(ArregloC);

    }// end Arreclo C suma

    public void ArregloC2() {
        CrearArregloC(ArregloC, ArregloB, ArregloA, 2);// restandose
        ImprimirArreglo(ArregloC);
    }// end Arreclo C resta

    public void ArregloC3() {
        CrearArregloC(ArregloC, ArregloB, ArregloA, 3);// multimplicandose
        ImprimirArreglo(ArregloC);
    }// end Arreclo C multimplicacion

    public void Promedio(int[][] x) {
        int suma = 0;
        int promedio = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                suma += x[i][j];
                System.out.print("[" + x[i][j] + "]+");
            } // end for
            promedio = suma / R;
            System.out.println("=" + promedio);
            suma = 0;
            promedio = 0;
        } // end for
    }// end promedio

    public void PromedioA() {
        Promedio(ArregloA);
    }// end promedio A

    public void PromedioB() {
        Promedio(ArregloB);
    }// end promedio B

    public void ClonarC() {
        ArregloC = ArregloA.clone();
        System.out.println("El arreglo A:");
        ImprimirArreglo(ArregloA);
        System.out.println("\nEl arreglo C:");
        ImprimirArreglo(ArregloC);
    }// end Clonar c
}// end class
