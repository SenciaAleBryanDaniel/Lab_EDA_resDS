package Lab04_ListasEnlazadas.Ejr_ProbPropuestos.Ejercicio07PP;

/*Implementar una lista circular que tenga los elementos del 1 al 12 utilizando la clase nodo en java y
modificar los métodos vistos en los ejercicios propuestos (insert, printList, deleteByKey, deleteAtPosition,
size, removeFirst, removelast, addFirst y addLast) y probar una clase Principal con un menú de opciones
para probar los métodos. */


import java.util.Scanner;

public class CircularCompLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E d) { data = d; }
    }

    private Node<E> tail;      
    private int size = 0;

    public void insert(E e) { addLast(e); }       
    public void addLast(E e) {                       
        Node<E> n = new Node<>(e);
        if (tail == null) { n.next = n; tail = n; }
        else { n.next = tail.next; tail.next = n; tail = n; }
        size++;
    }
    public void addFirst(E e) {                    
        Node<E> n = new Node<>(e);
        if (tail == null) { n.next = n; tail = n; }
        else { n.next = tail.next; tail.next = n; }
        size++;
    }
    public void printList() {
        if (tail == null) { System.out.println("Lista: []"); return; }
        System.out.print("Lista: ");
        Node<E> p = tail.next;          
        do {
            System.out.print(p.data + (p.next == tail.next ? "" : " -> "));
            p = p.next;
        } while (p != tail.next);
        System.out.println();
    }
    public boolean deleteByKey(E key) {
        if (tail == null) return false;
        Node<E> prev = tail, curr = tail.next;
        for (int i = 0; i < size; i++) {
            if (key == null ? curr.data == null : key.equals(curr.data)) {
                removeNode(prev, curr);
                return true;
            }
            prev = curr; curr = curr.next;
        }
        return false;
    }
    public E deleteAtPosition(int idx) {
        check(idx);
        if (idx == 0) return removeFirst();
        Node<E> prev = tail.next;          
        for (int i = 1; i < idx; i++) prev = prev.next;
        Node<E> curr = prev.next;
        E data = curr.data;
        removeNode(prev, curr);
        return data;
    }
    private E removeFirst() {             
        Node<E> head = tail.next;
        E data = head.data;
        removeNode(tail, head);
        return data;
    }
    public void removeFirstOp() { if (size > 0) removeFirst(); }
    public void removeLast() {
        if (tail == null) return;
        Node<E> prev = tail.next;
        while (prev.next != tail) prev = prev.next;
        removeNode(prev, tail);
    }
    private void removeNode(Node<E> prev, Node<E> curr) {
        if (size == 1) { tail = null; }
        else {
            prev.next = curr.next;
            if (curr == tail) tail = prev;     
        }
        size--;
    }
    public int size() { return size; }
    private void check(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException(i);
    }

    private static void menu(CircularCompLinkedList<Integer> list) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n===== MENÚ LISTA CIRCULAR SIMPLE =====");
            System.out.println("1) insert (al final)");
            System.out.println("2) addFirst");
            System.out.println("3) addLast");
            System.out.println("4) deleteByKey");
            System.out.println("5) deleteAtPosition");
            System.out.println("6) removeFirst");
            System.out.println("7) removeLast");
            System.out.println("8) size");
            System.out.println("9) Mostrar lista");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> { System.out.print("Valor: "); list.insert(sc.nextInt());                       list.printList(); }
                case 2 -> { System.out.print("Valor: "); list.addFirst(sc.nextInt());                    list.printList(); }
                case 3 -> { System.out.print("Valor: "); list.addLast(sc.nextInt());                     list.printList(); }
                case 4 -> { System.out.print("Clave: "); System.out.println(list.deleteByKey(sc.nextInt())
                                                           ? "Eliminado" : "No encontrado");              list.printList(); }
                case 5 -> { System.out.print("Índice: "); try { System.out.println("Eliminado: " +
                                list.deleteAtPosition(sc.nextInt())); } catch(Exception e){
                                System.out.println("Índice fuera de rango"); }                           list.printList(); }
                case 6 -> { list.removeFirstOp();                                                        list.printList(); }
                case 7 -> { list.removeLast();                                                           list.printList(); }
                case 8 -> { System.out.println("size = " + list.size());                                 list.printList(); }
                case 9 ->   list.printList();
                case 0 ->   System.out.println("Fin del programa");
                default ->  System.out.println("Opción inválida");
            }
        } while (op != 0);
        sc.close();
    }

    public static void main(String[] args) {
        CircularCompLinkedList<Integer> lista = new CircularCompLinkedList<>();
        for (int i = 1; i <= 10; i++) lista.insert(i);
        lista.printList();                             
        menu(lista);
    }
}
