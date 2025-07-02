package Lab07_ArbolBinarioAVL_Balanceado.EjrProbPropuestos.Ejercicio03;

import java.util.Scanner;

public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n--- Menú AVL (Ej 03) ---");
            System.out.println("1.Insertar 2.Eliminar 3.Buscar");
            System.out.println("4.Min/Max 5.Pred/Succ");
            System.out.println("6.Recorridos 7.Graficar");
            System.out.println("8.Destroy 9.isEmpty 0.Salir");
            System.out.print("Opción: ");
            opt = sc.nextInt();
            switch(opt) {
                case 1: System.out.print("Valor: "); tree.insert(sc.nextInt()); break;
                case 2: System.out.print("Valor: "); tree.remove(sc.nextInt()); break;
                case 3: System.out.print("Valor: ");
                        System.out.println(tree.search(sc.nextInt()) ? "Sí" : "No"); break;
                case 4: System.out.println("Min: " + tree.Min());
                        System.out.println("Max: " + tree.Max()); break;
                case 5: System.out.print("Valor: ");
                        int v = sc.nextInt();
                        System.out.println("Pred: " + tree.Predecesor(v));
                        System.out.println("Succ: " + tree.Sucesor(v)); break;
                case 6: System.out.print("In: "); tree.InOrder();
                        System.out.print("Pre: "); tree.PreOrder();
                        System.out.print("Post: "); tree.PostOrder(); break;
                case 7: if (tree.isEmpty()) System.out.println("Vacío");
                        else tree.graficar(); break;
                case 8: tree.destroy(); System.out.println("Árbol destruido."); break;
                case 9: System.out.println(tree.isEmpty() ? "Vacío" : "No vacío"); break;
                case 0: System.out.println("¡Chau!"); break;
                default: System.out.println("Inválido.");
            }
        } while(opt != 0);
        sc.close();
    }
}