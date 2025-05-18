package Ejr_ProbResDocente;

import java.util.Scanner;

/* Implementa un algoritmo que determine si una lista de números ingresados 
por el usuario está ordenada de manera ascendente. Debes usar un concepto 
de invariante dentro del bucle para garantizar que la propiedad de orden se 
mantiene durante la ejecución.
*/

public class Ejercicio03RD {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de elementos: ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        System.out.println("Ingrese los números:");

        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        boolean estaOrdenada = true;

        for (int i = 1; i < n; i++) {
            if (numeros[i] < numeros[i - 1]) {
            estaOrdenada = false;
            break;
            }
        }

        System.out.println("¿Está ordenada la lista?: " + (estaOrdenada ? "Sí" :
        "No"));
        scanner.close();

    }
}