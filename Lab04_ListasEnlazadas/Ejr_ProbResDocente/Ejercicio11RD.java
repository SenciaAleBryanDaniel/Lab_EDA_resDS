package Lab04_ListasEnlazadas.Ejr_ProbResDocente;

/*Mostrar un programa en java que utilice la librería java.util y muestre 
el uso del método size().*/

import java.util.LinkedList;
public class Ejercicio11RD {
    public static void main(String args[]) {
LinkedList<String> list = new LinkedList<String>();
list.add("Uno, Dos, Tres ");
list.add("Cuatro ");
// Mostrar el tamaño de la lista
System.out.println("El tamaño de la lista es: " + list.size());
}
}