package Lab04_ListasEnlazadas.Ejr_ProbPropuestos.Ejercicio06PP;

/* .Implementar una lista doblemente enlazada que tenga los elementos 
del 1 al 10, usando la clase nodo en java y modificar los métodos vistos 
en los ejercicios propuestos (insert, printList, deleteByKey,deleteAtPosition, 
size, removeFirst, removelast, addFirst y addLast) y probar una clase 
Principal con un menú de opciones para probar los métodos. */

import java.util.Scanner;

public class SimpleLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> prev, next;
        Node(E d) { data = d; }
    }

    private Node<E> head, tail;
    private int size = 0;

    public void insert(E e) { addLast(e); }
    public void addFirst(E e) {
        Node<E> n = new Node<>(e);
        if (head == null) head = tail = n;
        else { n.next = head; head.prev = n; head = n; }
        size++;
    }
    public void addLast(E e) {
        Node<E> n = new Node<>(e);
        if (head == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
        size++;
    }
    public void printList() {
        System.out.print("Lista: ");
        Node<E> p = head;
        while (p != null) {
            System.out.print(p.data + (p.next == null ? "" : " <-> "));
            p = p.next;
        }
        System.out.println();
    }
    public boolean deleteByKey(E key) {
        Node<E> p = head;
        while (p != null && !(key == null ? p.data == null : key.equals(p.data))) {
            p = p.next;
        }
        if (p == null) return false;
        unlink(p);
        return true;
    }
    public E deleteAtPosition(int idx) {
        check(idx);
        Node<E> p = node(idx);
        E data = p.data;
        unlink(p);
        return data;
    }
    public void removeFirst() { if (head != null) unlink(head); }
    public void removeLast()  { if (tail != null) unlink(tail); }
    public int size() { return size; }

    private void unlink(Node<E> p) {
        if (p.prev == null) head = p.next; else p.prev.next = p.next;
        if (p.next == null) tail = p.prev; else p.next.prev = p.prev;
        size--;
    }
    private Node<E> node(int i) {
        Node<E> p = head;
        for (int k = 0; k < i; k++) p = p.next;
        return p;
    }
    private void check(int i) { if (i < 0 || i >= size) throw new IndexOutOfBoundsException(i); }

    private static void menu(SimpleLinkedList<Integer> list) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n===== MENÚ LISTA DOBLE ENLAZADA =====");
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
                case 1 -> { System.out.print("Valor: "); list.insert(sc.nextInt());                      list.printList(); }
                case 2 -> { System.out.print("Valor: "); list.addFirst(sc.nextInt());                   list.printList(); }
                case 3 -> { System.out.print("Valor: "); list.addLast(sc.nextInt());                    list.printList(); }
                case 4 -> { System.out.print("Clave: ");  System.out.println(list.deleteByKey(sc.nextInt())
                                                          ? "Eliminado" : "No encontrado");             list.printList(); }
                case 5 -> { System.out.print("Índice: "); try { System.out.println("Eliminado: " +
                               list.deleteAtPosition(sc.nextInt())); } catch(Exception e){
                               System.out.println("Índice fuera de rango"); }                           list.printList(); }
                case 6 -> { list.removeFirst();                                                          list.printList(); }
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
        SimpleLinkedList<Integer> lista = new SimpleLinkedList<>();
        for (int i = 1; i <= 10; i++) lista.insert(i);   
        lista.printList();                              
        menu(lista);
    }
}
