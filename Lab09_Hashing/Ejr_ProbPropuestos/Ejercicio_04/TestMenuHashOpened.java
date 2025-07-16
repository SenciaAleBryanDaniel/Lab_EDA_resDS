package Lab09_Hashing.Ejr_ProbPropuestos.Ejercicio_04;

import java.util.Scanner;

public class TestMenuHashOpened {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashOpened<String> tabla = new HashOpened<>(8);
        int option;

        do {
            System.out.println("\n--- Menú de operaciones ---");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Eliminar");
            System.out.println("4. Mostrar tabla");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    int key = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    String value = scanner.next();
                    tabla.insert(new Register<>(key, value));
                    break;
                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    key = scanner.nextInt();
                    Register<String> result = tabla.search(key);
                    System.out.println(result != null ? result : "No encontrado");
                    break;
                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    key = scanner.nextInt();
                    tabla.delete(key);
                    break;
                case 4:
                    tabla.showTable();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 5);

        scanner.close();
    }
}
