package Lab04_ListasEnlazadas.Ejr_ProbPropuestos.Ejercicio02PP;

/* 2. Implementar una lista circular que tenga los elementos 
del 1 al 12 utilizando la clase nodo */

public class CircularLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E d) { data = d; }
    }

    private Node<E> tail;        
    private int size = 0;

    public void addLast(E e) {
        Node<E> n = new Node<>(e);
        if (tail == null) {          
            n.next = n;
            tail = n;
        } else {
            n.next = tail.next;
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void print() {
        if (tail == null) { System.out.println("[]"); return; }
        Node<E> p = tail.next;          // primer nodo
        System.out.print("Lista: ");
        do {
            System.out.print(p.data + (p.next == tail.next ? "" : " "));
            p = p.next;
        } while (p != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();
        for (int i = 1; i <= 12; i++) lista.addLast(i);
        lista.print();              
    }
}

