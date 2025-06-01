package Lab04_ListasEnlazadas.Ejr_ProbPropuestos.Ejercicio01PP;

/*Implementar una lista doblemente enlazada que tenga los elementos 
del 1 al 10, usando la clase nodo en java. */

public class DobleLinkedList<E> {           
    private static class Node<E> {
        E data;
        Node<E> prev, next;
        Node(E d) { data = d; }
    }

    private Node<E> head, tail;
    private int size = 0;

    public void addLast(E elem) {
        Node<E> n = new Node<>(elem);
        if (head == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
        size++;
    }

    public void printForward() {
        Node<E> p = head;
        System.out.print("Lista: ");
        while (p != null) {
            System.out.print(p.data + (p.next == null ? "" : " "));
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DobleLinkedList<Integer> lista = new DobleLinkedList<>();
        for (int i = 1; i <= 10; i++) lista.addLast(i);
        lista.printForward();       
    }
}

