package Tareas;//tarea 1

import java.util.Arrays;
import java.util.Scanner;

public class  Arreglos_Unidimensionales {//Tarea 1 estructura de datos
    private int[] Arreglo;
    static int n;
    int t;
    static String Line = "----------------------------------------------------";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Cual es el tamaño del arreglo?");
        n = s.nextInt();

        Arreglos_Unidimensionales Au = new Arreglos_Unidimensionales(n);
        System.out.println(Line);// sirve para tener una separacion y una mejor estetica
        Au.Llenar();
        System.out.println(Line);
        Au.DeMenorAMayor();
        System.out.println(Line);
        Au.Promedio();
        System.out.println(Line);
        Au.Moda();
        System.out.println(Line);
        Au.Mediana();
        System.out.println(Line);
        Au.Posicion0();
        System.out.println(Line);
        Au.PosicionN();
        System.out.println(Line);
        Au.ValorMax();
        System.out.println(Line);
        Au.ValorMin();
        System.out.println();
        s.close();
    }// end main

    
    public Arreglos_Unidimensionales(int n) {// Sirve para crear el arreglo
        t = n;
        Arreglo = new int[t];
    }//end metodos arreglos

    public void Llenar() {// Sirve para llenar el arreglo de numero aleatorios

        for (int i = 0; i < n; i++) {
            int numero = (int) (Math.random() * 100 + 1);
            Arreglo[i] = numero;
        }
        System.out.println("Este es el arreglo original\n" + Arrays.toString(Arreglo));
        // convierte el array en String y lo imprime
    }//end llenar

    public void DeMenorAMayor() {
        Arrays.sort(Arreglo);// ordena el array de menor a mayor
        System.out.println("Arreglo ordenado de menor a mayor\n" + Arrays.toString(Arreglo));
    }//end DeMenorAMayor

    public void Promedio() {
        int promedio, suma = 0;
        for (int i = 0; i < Arreglo.length; i++) {
            suma += Arreglo[i];

        } // end for
        promedio = suma / n;
        System.out.println("La suma es de: " + suma + "\nEl promedio es de : " + promedio);
    }//end Promedio

    public void Moda() {
        int moda = 0, max_rep = 0;

        for (int i = 0; i < Arreglo.length; i++) {
            int veces_rep = 0;

            for (int j = 0; j < Arreglo.length; j++) {

                if (Arreglo[i] == Arreglo[j]) {
                    veces_rep++;
                } // end if

                if (veces_rep > max_rep) {
                    moda = Arreglo[i];
                    max_rep = veces_rep;
                } // end if
            } // end for
        } // end for
        if (max_rep == 1) {
            System.out.println("Ningun numero se repitio, por lo tanto no tiene moda ");
        } else {
            System.out.println("La moda es: " + moda + "\nSe repitio " + max_rep+ " veces ");
        }
    }//end Moda

    public void Mediana() {
        int Tamano=n+1;
        int mediana = (Tamano/2)-1;
        if (n%2==0) {
            double suma = Arreglo[mediana]+ Arreglo[mediana+1];
            double promedio = suma/2;
            System.out.println("La mediana es el numero: "+ promedio);
        }else{
            System.out.println("La mediana es el numero: "+Arreglo[mediana]);
        }//end if
    }//end Mediana

    public void Posicion0() {
        System.out.println("Numero en posicion 0: "+Arreglo[0]);
    }//end  Posicion 0

    public void PosicionN() {
        int x=Arreglo.length-1;
        System.out.println("Numero en posicion n: "+Arreglo[x]);
    }//end  Posicion N
    
    public void ValorMax() {
        int NumMayor = 0;
        for (int i = 0; i < Arreglo.length; i++) {
            if (Arreglo[i] > NumMayor) {
                NumMayor = Arreglo[i];
            }
        }
        System.out.println("El numero mayor es: " + NumMayor);
    }//end Valor Maximo

    public void ValorMin() {
        int NumMenor = 101;
        for (int i = 0; i < Arreglo.length; i++) {
            if (Arreglo[i] < NumMenor) {
                NumMenor = Arreglo[i];
            }
        }
        System.out.println("El numero menor es: " + NumMenor);

    }// end Valor Minimo

}// end class
