
//Implementación Clase BST Genérico.

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }

    public void destroy() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T x) {
        root = insertRec(root, x);
    }

    private Node<T> insertRec(Node<T> node, T x) {
        if (node == null) {
            return new Node<>(x);
        }
        if (x.compareTo(node.getData()) <= 0) {
            node.setLeft(insertRec(node.getLeft(), x));
        } else {
            node.setRight(insertRec(node.getRight(), x));
        }
        return node;
    }

    public boolean search(T x) {
        return (searchRec(root, x) != null);
    }

    private Node<T> searchRec(Node<T> node, T x) {
        if (node == null || x.equals(node.getData())) {
            return node;
        }
        if (x.compareTo(node.getData()) < 0) {
            return searchRec(node.getLeft(), x);
        } else {
            return searchRec(node.getRight(), x);
        }
    }

}
