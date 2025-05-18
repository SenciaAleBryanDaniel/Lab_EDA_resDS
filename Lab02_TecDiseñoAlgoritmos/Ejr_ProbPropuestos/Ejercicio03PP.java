package Lab02_TecDiseñoAlgoritmos.Ejr_ProbPropuestos;

//Triangulo recursivo 1. El método trianguloRecursivo1 calcula y muestra el resultado.

import java.util.Scanner;

public class Ejercicio03PP {
    
    public void trianguloRecursivo1(int base) {
         if (base > 0) {
            trianguloRecursivo1(base - 1); 
            for (int i = 0; i < base; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Ejercicio03PP obj = new Ejercicio03PP();
        Scanner sc = new Scanner(System.in);
        System.out.print("Tamaño de la base: ");
        int base = sc.nextInt();
        obj.trianguloRecursivo1(base);
    }
}
