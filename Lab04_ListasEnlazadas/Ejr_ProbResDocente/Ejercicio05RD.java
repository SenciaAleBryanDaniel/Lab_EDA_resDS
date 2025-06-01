package Lab04_ListasEnlazadas.Ejr_ProbResDocente;

/* Ejercicio 05: Crear una lista enlazada utilizando java.util.linkedList, 
que tenga los elementos uno, dos, tres, cuatro y cinco */

// Un programa java para añadir elementos a una LinkedList
import java.util.LinkedList;
public class Ejercicio05RD {
// Metodo principal
    public static void main(String[] args) {
        // Creando unaLinkedList
        LinkedList<String> lst = new LinkedList<String>();
        // Añadiendo los elementos a la LinkedList usando el método add()
        lst.add("Uno");
        lst.add("Dos");
        lst.add("Tres");
        lst.add("Cuatro");
        lst.add("Cinco");
        // Imprimiendo la LinkedList
        System.out.println(lst);
    }
}