package Lab02_TecDiseñoAlgoritmos.Ejr_ProbPropuestos;

import java.util.Arrays;
import java.util.Scanner;

/* Invertir vector de enteros, permite ingresar tamaño y captura 
de valores del arreglo, el método
invertirArray calcula y muestra el resultado.
*/

public class Ejercicio01PP {

    public int[] ivertirArray(int[] A, int n){
        int [] Asalida = new int[n];
        if(n>0){
            for(int k=0; k<n; k++){
                Asalida[k] = A[n-1-k];
            }
        }
        return Asalida;
    }

    public static void main(String[] args){
        Ejercicio01PP obj = new Ejercicio01PP();
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Tamaño del arreglo? ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Ingresa los " + n + " elementos:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int[] Asalida = obj.ivertirArray(A, n);
        System.out.println("Array Invertido " + Arrays.toString(Asalida));

    }
}
