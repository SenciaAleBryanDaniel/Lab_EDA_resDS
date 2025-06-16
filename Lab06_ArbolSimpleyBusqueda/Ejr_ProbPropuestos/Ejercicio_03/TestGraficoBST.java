package Ejercicio_03;

/**
 * Clase de prueba para visualizar un BST con GraphStream.
 */
public class TestGraficoBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        int[] valores = {20, 10, 30, 5, 15, 25, 35};
        for (int v : valores) {
            tree.insert(v);
        }
        tree.graphBST();
    }
}
