package Lab04_ListasEnlazadas.Ejr_ProbResDocente;

/*Ejercicio 07: Crear una lista enlazada utilizando la librería java.util que 
implemente el añadido de elementos por posición. */

// Programa java para añadir elementos
// a la LinkedList
import java.util.*;
public class Ejercicio07RD {
public static void main(String args[]) {
LinkedList<String> ll = new LinkedList<>();
ll.add("Uno");
ll.add("Tres");
ll.add(1, "Dos");
System.out.println(ll);
}
}
