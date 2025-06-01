package Lab04_ListasEnlazadas.Ejr_ProbResDocente;

/*Ejercicio 08: Crear una lista enlazada utilizando la librería java.util 
que implemente el cambio de elemento usando el método set(). */

import java.util.*;
public class Ejercicio08RD {
    public static void main(String args[]) {
    LinkedList<String> ll = new LinkedList<>();
    ll.add("Uno");
    ll.add("Dos");
    ll.add(1, "Tres");
    System.out.println("Initial LinkedList " + ll);
    ll.set(1, "Cuatro");
    System.out.println("Updated LinkedList " + ll);
    }
}