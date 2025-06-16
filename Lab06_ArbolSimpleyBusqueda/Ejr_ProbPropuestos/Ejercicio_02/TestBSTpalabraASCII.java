package Ejercicio_02;

// TestBSTASCII.java

import java.util.Scanner;
import java.util.List;

public class TestBSTpalabraASCII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();
        sc.close();

        BST<Integer> tree = new BST<>();
        for (char c : palabra.toCharArray()) {
            tree.insert((int) c);
        }

        List<Integer> ordenAscii = tree.inOrder();
        System.out.println("InOrder (ASCII): " + ordenAscii);
    }
}
