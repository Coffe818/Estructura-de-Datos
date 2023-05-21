package Tareas;

import java.util.Scanner;

public class RecorridosGrafos {

    public  void imprimirGrafo(int[][] matrizAdyacencia) {
        int numVertices = matrizAdyacencia.length;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }//end for para imprimir renglon
            System.out.println();
        }//end for para imprimir columnas o dar el espacio entre columnas
    }//end imprimir Grafo


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecorridosGrafos rec = new RecorridosGrafos();

        System.out.print("Ingrese el número de vértices: ");// el numero de espacios 2x2,4x4,5x5
        int numVertices = scanner.nextInt();

        int[][] matrizAdyacencia = new int[numVertices][numVertices];

        System.out.print("Ingrese el número de aristas: ");// el numero de datos dentor del espacio
        int numAristas = scanner.nextInt();

        for (int i = 0; i < numAristas; i++) {
            System.out.println("Ingrese los detalles de la arista " + (i + 1));
            System.out.print("Origen: ");// es el renglon
            int origen = scanner.nextInt();
            System.out.print("Destino: ");//es la columna
            int destino = scanner.nextInt();
            System.out.print("Peso: ");// el valor en su interseccion
            int peso = scanner.nextInt();

            matrizAdyacencia[origen][destino] = peso;
        }

        System.out.println("Grafo:");
        rec.imprimirGrafo(matrizAdyacencia);


        scanner.close();
    }
}//end clas
