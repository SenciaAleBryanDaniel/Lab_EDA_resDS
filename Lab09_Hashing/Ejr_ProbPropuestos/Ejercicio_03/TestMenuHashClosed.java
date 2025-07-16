package Lab09_Hashing.Ejr_ProbPropuestos.Ejercicio_03;


import java.util.Scanner;

public class TestMenuHashClosed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashClosed<String> hash = new HashClosed<>(11);
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
                    if (hash.insert(key, value)) {
                        System.out.println("Registro insertado.");
                    } else {
                        System.out.println("Error al insertar (duplicado o lleno).");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    key = scanner.nextInt();
                    String result = hash.search(key) != null ? hash.search(key) : "No encontrado";
                    System.out.println("Resultado de búsqueda: " + result);
                    break;
                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    key = scanner.nextInt();
                    if (hash.delete(key)) {
                        System.out.println("Registro eliminado.");
                    } else {
                        System.out.println("Clave no encontrada.");
                    }
                    break;
                case 4:
                    hash.show();
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

