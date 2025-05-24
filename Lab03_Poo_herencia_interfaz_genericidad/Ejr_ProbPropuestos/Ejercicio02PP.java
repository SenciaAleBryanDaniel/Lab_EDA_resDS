package Lab03_Poo_herencia_interfaz_genericidad.Ejr_ProbPropuestos;

/*
 *  Calculadora Genérica, Cree un nuevo proyecto en Java: CalculadoraGenerica
 */

import java.util.InputMismatchException;
import java.util.Scanner;

//operador generico
class Operador<T extends Number> {
    private T valor1;
    private T valor2;

    Operador(T valor1, T valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    T getValor1() { return valor1; }
    T getValor2() { return valor2; }
}

//metodos pedidos
class Calculadora {

    /* Convierte cualquier Number a double para operar con seguridad */
    private static double toDouble(Number n) { return n.doubleValue(); }

    public static <T extends Number> double suma(T a, T b) {
        return toDouble(a) + toDouble(b);
    }
    public static <T extends Number> double resta(T a, T b) {
        return toDouble(a) - toDouble(b);
    }
    public static <T extends Number> double producto(T a, T b) {
        return toDouble(a) * toDouble(b);
    }
    public static <T extends Number> double division(T a, T b) {
        return toDouble(a) / toDouble(b);
    }
    public static <T extends Number> double potencia(T a, T b) {
        return Math.pow(toDouble(a), toDouble(b));
    }
    public static <T extends Number> double raizCuadrada(T a) {
        return Math.sqrt(toDouble(a));
    }
    public static <T extends Number> double raizCubica(T a) {
        return Math.cbrt(toDouble(a));
    }
}

public class Ejercicio02PP {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nMenú de Operaciones (Genéricas)");
            System.out.println("1) Suma");
            System.out.println("2) Resta");
            System.out.println("3) Producto");
            System.out.println("4) División");
            System.out.println("5) Potencia");
            System.out.println("6) Raíz Cuadrada");
            System.out.println("7) Raíz Cúbica");
            System.out.println("8) Salir");
            System.out.print  ("Elige una opción: ");

            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ingresa un numero valido");
                sc.nextLine();
                continue;
            }

            if (opcion == 8) {
                System.out.println("Fin de la calculadora");
                break;
            }

            System.out.print("utilizar [1] Integer;  [2] Double: ");
            int tipo = sc.nextInt();

            if (opcion >= 1 && opcion <= 5) {       
                System.out.print("Ingresa el primer valor: ");
                Number v1 = (tipo == 1) ? sc.nextInt() : sc.nextDouble();
                System.out.print("Ingresa el segundo valor: ");
                Number v2 = (tipo == 1) ? sc.nextInt() : sc.nextDouble();

                Operador<? extends Number> op = new Operador<>(v1, v2);
                double res = switch (opcion) {
                    case 1 -> Calculadora.suma     (op.getValor1(), op.getValor2());
                    case 2 -> Calculadora.resta    (op.getValor1(), op.getValor2());
                    case 3 -> Calculadora.producto (op.getValor1(), op.getValor2());
                    case 4 -> Calculadora.division (op.getValor1(), op.getValor2());
                    default-> Calculadora.potencia (op.getValor1(), op.getValor2());
                };
                System.out.println("Resultado: " + res);

            } else if (opcion == 6 || opcion == 7) {    
                System.out.print("Ingresa el valor: ");
                Number v1 = (tipo == 1) ? sc.nextInt() : sc.nextDouble();

                double res = (opcion == 6)
                           ? Calculadora.raizCuadrada(v1)
                           : Calculadora.raizCubica  (v1);
                System.out.println("Resultado: " + res);

            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
