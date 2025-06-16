package Ejercicio_01;

import java.util.ArrayList;
import java.util.List;

//Implementacion del arbol binario de busqueda.

/* Implementar un arbol binario de búsqueda ABB o BST agregando todas las operaciones:
destroy(), isEmpty(), insert(x), remove(x), search(x), Min(), Max(), Predecesor(), Sucesor(), InOrder,
PostOrder(), PreOrder() */

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }
    //destroy()
    public void destroy() {
        root = null;
    }

    //isEmpty()
    public boolean isEmpty() {
        return root == null;
    }

    //insert(x)
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

    //remove(x)
    public void remove(T x) {
        root = removeRec(root, x);
    }
    
    //search(x)
    public boolean search(T x) {
        return searchRec(root, x) != null;
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

    //Min(x)
    public T min() {
        if (root == null) return null;
        Node<T> curr = root;
        while (curr.getLeft() != null) {
            curr = curr.getLeft();
        }
        return curr.getData();
    }

    //Max()
    public T max() {
        if (root == null) return null;
        Node<T> curr = root;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }
        return curr.getData();
    }

    private Node<T> removeRec(Node<T> node, T x) {
        if (node == null) return null;
        int cmp = x.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(removeRec(node.getLeft(), x));
        } else if (cmp > 0) {
            node.setRight(removeRec(node.getRight(), x));
        } else {
            if (node.getLeft() == null)  return node.getRight();
            if (node.getRight() == null) return node.getLeft();
            Node<T> succ = node.getRight();
            while (succ.getLeft() != null) succ = succ.getLeft();
            node.setData(succ.getData());
            node.setRight(removeRec(node.getRight(), succ.getData()));
        }
        return node;
    }

    public T predecessor(T x) {
        Node<T> pred = null;
        Node<T> curr = root;
        while (curr != null) {
            int cmp = x.compareTo(curr.getData());
            if (cmp > 0) {
                pred = curr;
                curr = curr.getRight();
            } else {
                curr = curr.getLeft();
            }
        }
        Node<T> node = searchRec(root, x);
        if (node != null && node.getLeft() != null) {
            Node<T> tmp = node.getLeft();
            while (tmp.getRight() != null) tmp = tmp.getRight();
            return tmp.getData();
        }
        return pred != null ? pred.getData() : null;
    }

    public T successor(T x) {
        Node<T> succ = null;
        Node<T> curr = root;
        while (curr != null) {
            int cmp = x.compareTo(curr.getData());
            if (cmp < 0) {
                succ = curr;
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        Node<T> node = searchRec(root, x);
        if (node != null && node.getRight() != null) {
            Node<T> tmp = node.getRight();
            while (tmp.getLeft() != null) tmp = tmp.getLeft();
            return tmp.getData();
        }
        return succ != null ? succ.getData() : null;
    }

//Implementacion de recorridos

    public List<T> inOrder() {
        List<T> res = new ArrayList<>();
        inOrderRec(root, res);
        return res;
    }
    private void inOrderRec(Node<T> node, List<T> out) {
        if (node == null) return;
        inOrderRec(node.getLeft(), out);
        out.add(node.getData());
        inOrderRec(node.getRight(), out);
    }

    public List<T> preOrder() {
        List<T> res = new ArrayList<>();
        preOrderRec(root, res);
        return res;
    }
    private void preOrderRec(Node<T> node, List<T> out) {
        if (node == null) return;
        out.add(node.getData());
        preOrderRec(node.getLeft(), out);
        preOrderRec(node.getRight(), out);
    }

    public List<T> postOrder() {
        List<T> res = new ArrayList<>();
        postOrderRec(root, res);
        return res;
    }
    private void postOrderRec(Node<T> node, List<T> out) {
        if (node == null) return;
        postOrderRec(node.getLeft(), out);
        postOrderRec(node.getRight(), out);
        out.add(node.getData());
    }
}
