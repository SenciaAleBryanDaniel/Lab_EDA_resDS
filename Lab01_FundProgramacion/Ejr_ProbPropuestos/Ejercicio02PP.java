package Ejr_ProbPropuestos;

import java.util.Arrays;

/*: Implementa un programa en Java que encuentre todos los números 
primos en un rango definido por el usuario utilizando el algoritmo 
de la Criba de Eratóstenes
*/

import java.util.Scanner;

public class Ejercicio02PP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Límite inferior: ");
        int inicio = sc.nextInt();
        System.out.print("Límite superior: ");
        int fin = sc.nextInt();
        if (fin < 2 || fin < inicio) {
            System.out.println("Rango no válido.");
            sc.close();
            return;
        }

        boolean[] primo = new boolean[fin + 1];
        Arrays.fill(primo, true);
        primo[0] = primo[1] = false;

        for (int i = 2; i * i <= fin; i++) {
            if (primo[i]) {
                for (int j = i * i; j <= fin; j += i) {
                    primo[j] = false;
                }
            }
        }

        System.out.println("Primos entre " + inicio + " y " + fin + ":");
        for (int i = Math.max(inicio, 2); i <= fin; i++) {
            if (primo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        sc.close();
    }
}
