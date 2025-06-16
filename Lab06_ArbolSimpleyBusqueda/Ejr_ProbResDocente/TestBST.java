
// 

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        System.out.println("El arbol esta lleno? " + tree.isEmpty());
        int[] vals = {10, 5, 15, 3, 7, 45, 67, 6, 78};
        for (int v : vals) {
            tree.insert(v);
        }
        System.out.println("DESPUES  DEL llenado de datos");
        System.out.println("El arbol esta lleno? " + tree.isEmpty());
        System.out.println("Buscar 7: " + tree.search(7));
        System.out.println("Buscar 9: " + tree.search(9));
    }
}
