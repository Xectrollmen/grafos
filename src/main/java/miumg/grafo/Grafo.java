/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package miumg.grafo;

import java.util.Scanner;

/**
 *
 * @author pluis
 */
public class Grafo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantVertices = 0;
        System.out.println("Ingresa la cantidad de vertices: ");
        cantVertices = sc.nextInt();
        
        int[][] grafo = new int[cantVertices][cantVertices];
        
        for (int i = 0; i < cantVertices; i++) {
            for (int j = 0; j < cantVertices; j++) {
                System.out.print("Ingrese el peso de la Vertice ["+ (i + 1) + " , "+ (j + 1) + "] : \n");
                int arista = sc.nextInt();
                grafo[i][j] = arista;
            }
        }
        
        System.out.println("Grafo:");
        for (int i = 0; i < cantVertices; i++) {
            for (int j = 0; j < cantVertices; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
    }
}
