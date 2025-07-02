package Ejercicio_03;

import java.util.ArrayList;
import java.util.List;

//importando la libreria
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

//Implementacion del arbol binario de busqueda con operaciones 
//Agregandole las librerias requeridas para este ejercicio ademas 
// de cosas utilizadas por la libreria con el fin de graficar nuestro arboles

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }

    public void destroy() { root = null; }

    public boolean isEmpty() { return root == null; }

    public void insert(T x) {
        root = insertRec(root, x);
    }
    private Node<T> insertRec(Node<T> node, T x) {
        if (node == null) return new Node<>(x);
        if (x.compareTo(node.getData()) <= 0)
            node.setLeft(insertRec(node.getLeft(), x));
        else
            node.setRight(insertRec(node.getRight(), x));
        return node;
    }

    public boolean search(T x) {
        return searchRec(root, x) != null;
    }
    private Node<T> searchRec(Node<T> node, T x) {
        if (node == null || x.equals(node.getData())) return node;
        if (x.compareTo(node.getData()) < 0)
            return searchRec(node.getLeft(), x);
        else
            return searchRec(node.getRight(), x);
    }

    public T min() {
        if (root == null) return null;
        Node<T> curr = root;
        while (curr.getLeft() != null) curr = curr.getLeft();
        return curr.getData();
    }

    public T max() {
        if (root == null) return null;
        Node<T> curr = root;
        while (curr.getRight() != null) curr = curr.getRight();
        return curr.getData();
    }

    public void remove(T x) {
        root = removeRec(root, x);
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
            // dos hijos: reemplazo con sucesor
            Node<T> succ = node.getRight();
            while (succ.getLeft() != null) succ = succ.getLeft();
            node.setData(succ.getData());
            node.setRight(removeRec(node.getRight(), succ.getData()));
        }
        return node;
    }

    public List<T> inOrder() {
        List<T> out = new ArrayList<>();
        inOrderRec(root, out);
        return out;
    }
    private void inOrderRec(Node<T> node, List<T> out) {
        if (node == null) return;
        inOrderRec(node.getLeft(), out);
        out.add(node.getData());
        inOrderRec(node.getRight(), out);
    }


    //graficando con Graph Stream
    public void graphBST() {
        System.setProperty("org.graphstream.ui", "swing");
        Graph g = new SingleGraph("BST");
        g.setAttribute("ui.stylesheet",
            "node { text-size: 16; } edge { arrow-shape: none; }");

        buildGraph(root, g);
        g.display();
    }

    private void buildGraph(Node<T> bstNode, Graph g) {
        if (bstNode == null) return;

        String id = bstNode.getData().toString();

        org.graphstream.graph.Node gsNode = g.getNode(id);
        if (gsNode == null) {
            gsNode = g.addNode(id);
            gsNode.setAttribute("ui.label", id);
        }

        if (bstNode.getLeft() != null) {
            String lid = bstNode.getLeft().getData().toString();
            if (g.getNode(lid) == null) {
                org.graphstream.graph.Node leftGS = g.addNode(lid);
                leftGS.setAttribute("ui.label", lid);
            }
            g.addEdge(id + "_L_" + lid, id, lid);
            buildGraph(bstNode.getLeft(), g);
        }

        if (bstNode.getRight() != null) {
            String rid = bstNode.getRight().getData().toString();
            if (g.getNode(rid) == null) {
                org.graphstream.graph.Node rightGS = g.addNode(rid);
                rightGS.setAttribute("ui.label", rid);
            }
            g.addEdge(id + "_R_" + rid, id, rid);
            buildGraph(bstNode.getRight(), g);
        }
    }
}
