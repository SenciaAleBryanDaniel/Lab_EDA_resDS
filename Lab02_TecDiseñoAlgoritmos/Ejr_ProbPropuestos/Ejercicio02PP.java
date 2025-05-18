package Lab02_TecDiseñoAlgoritmos.Ejr_ProbPropuestos;

import java.util.Arrays;
import java.util.Scanner;

/*Rotar a la Izquierda, permite ingresar tamaño y captura de valores del arreglo, el método
rotarIzquierdaArray calcula y muestra el resultado.
 */

public class Ejercicio02PP {
    
    public int[] rotarIzquierdaArray(int[] A, int n, int cantmoviz){
        int[] Ainvertido = new int[n];
        for(int i=0; i<n-cantmoviz; i++){
            Ainvertido[i] = A[cantmoviz+i];
        }
        for(int k=0; k<cantmoviz; k++){
            Ainvertido[n-cantmoviz+k] = A[k];
        }
        return Ainvertido;
    }

    public static void main(String[] args){
        Ejercicio02PP obj = new Ejercicio02PP();
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Tamaño del arreglo? ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Ingresa los " + n + " elementos:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("¿Cuantos elementos quiere mover a la izquierda? ");
        int cantmoviz = sc.nextInt();
        if(cantmoviz > n){
            System.out.println("El numero de elementos que quiere poner a la izquierda es mayor al permitido");
        }else{
            int[] Asalida = obj.rotarIzquierdaArray(A, n, cantmoviz);  
            System.out.println("El arreglo invertido es " + Arrays.toString(Asalida));
        }
    }
}
