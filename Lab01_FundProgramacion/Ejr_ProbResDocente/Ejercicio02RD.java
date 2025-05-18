package Ejr_ProbResDocente;

import java.util.Scanner;

/*: Escribe un programa en Java que permita calcular la suma de 
los primeros N números naturales usando un bucle while. 
El usuario debe ingresar el valor de N.
 */

public class Ejercicio02RD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número N: ");
        int n = scanner.nextInt();
        int suma = 0, contador = 1;
        while (contador <= n) {
            suma += contador;
            contador++;
        }
        System.out.println("La suma de los primeros " 
        + n + " números naturales es: "+ suma);
        scanner.close();
    }
}
