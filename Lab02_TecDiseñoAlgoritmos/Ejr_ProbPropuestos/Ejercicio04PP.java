package Lab02_TecDiseñoAlgoritmos.Ejr_ProbPropuestos;

//  Triángulo recursivo 2. El método trianguloRecursivo2 calcula y muestra el resultado.

import java.util.Scanner;

public class Ejercicio04PP {
    private int baseMaxima;
    void trianguloRecursivo2(int base) {
        if (base > 0) {
            trianguloRecursivo2(base - 1);
            for (int i = 0; i < baseMaxima - base; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < base; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio04PP obj = new Ejercicio04PP();

        System.out.print("Tamaño de la base: ");
        obj.baseMaxima = sc.nextInt();

        obj.trianguloRecursivo2(obj.baseMaxima);
        sc.close();
    }
}
