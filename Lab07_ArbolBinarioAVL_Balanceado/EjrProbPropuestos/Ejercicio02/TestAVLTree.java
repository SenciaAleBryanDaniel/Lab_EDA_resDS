package Lab07_ArbolBinarioAVL_Balanceado.EjrProbPropuestos.Ejercicio02;

import java.util.Scanner;

public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n--- Menú Árbol AVL ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Min / Max");
            System.out.println("5. Predecesor / Sucesor");
            System.out.println("6. Recorridos");
            System.out.println("7. Destroy");
            System.out.println("8. isEmpty");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = sc.nextInt();
            switch(option) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    tree.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Valor a eliminar: ");
                    tree.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    System.out.println(tree.search(sc.nextInt()) ? "Encontrado" : "No encontrado");
                    break;
                case 4:
                    System.out.println("Mínimo: " + tree.Min());
                    System.out.println("Máximo: " + tree.Max());
                    break;
                case 5:
                    System.out.print("Valor para predecesor/sucesor: ");
                    int v = sc.nextInt();
                    System.out.println("Predecesor: " + tree.Predecesor(v));
                    System.out.println("Sucesor: " + tree.Sucesor(v));
                    break;
                case 6:
                    System.out.println("InOrder: "); tree.InOrder();
                    System.out.println("PreOrder: "); tree.PreOrder();
                    System.out.println("PostOrder: "); tree.PostOrder();
                    break;
                case 7:
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                    break;
                case 8:
                    System.out.println(tree.isEmpty() ? "El árbol está vacío." : "El árbol NO está vacío.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while(option != 0);
        sc.close();
    }
}
