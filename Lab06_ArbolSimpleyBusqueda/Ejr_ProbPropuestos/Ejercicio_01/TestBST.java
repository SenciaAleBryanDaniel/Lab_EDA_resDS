package Ejercicio_01;

// Probando la implementacion de lo pedido ene el ejercicio 01

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        System.out.println("1) Árbol vacío? " + tree.isEmpty());

        int[] valores = {20, 10, 30, 5, 15, 25, 35};
        for (int v : valores) tree.insert(v);

        System.out.println("2) Árbol vacío? " + tree.isEmpty());
        System.out.println("3) Min: " + tree.min());
        System.out.println("4) Max: " + tree.max());
        System.out.println("5) Buscar 15: " + tree.search(15));
        System.out.println("6) Buscar 99: " + tree.search(99));
        System.out.println("7) InOrder: "  + tree.inOrder());
        System.out.println("8) PreOrder: " + tree.preOrder());
        System.out.println("9) PostOrder:"+ tree.postOrder());
        System.out.println("10) Predecesor de 20: " + tree.predecessor(20));
        System.out.println("11) Sucesor de 20:   " + tree.successor(20));

        tree.remove(20);
        System.out.println("12) InOrder tras remove(20): " + tree.inOrder());

        tree.destroy();
        System.out.println("13) Árbol tras destroy(): " + tree.isEmpty());
    }
}

