package Lab04_ListasEnlazadas.Ejr_ProbResDocente;

/*Crear una lista enlazada utilizando una clase LinkedList y una 
clase nodo e ingresar los elementos 1, 2, 3, 4, 5, 6, 7 y 8. */

public class Ejercicio01RD {
    Node head;
    
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Ejercicio01RD insert( Ejercicio01RD list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(Ejercicio01RD list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {

        Ejercicio01RD list = new Ejercicio01RD();
        list = insert(list, 5);
        list = insert(list, 2);
        list = insert(list, 7);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 3);
        list = insert(list, 1);
        list = insert(list, 8);

        printList(list);

    }
}
