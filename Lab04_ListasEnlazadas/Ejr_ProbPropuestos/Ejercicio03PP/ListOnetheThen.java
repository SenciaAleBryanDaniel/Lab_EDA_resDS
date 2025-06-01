package Lab04_ListasEnlazadas.Ejr_ProbPropuestos.Ejercicio03PP;

/*Implementar una lista doblemente enlazada que tenga los elementos 
del 1 al 10, usando la librería java.util */

import java.util.LinkedList;

public class ListOnetheThen {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 1; i <= 10; i++) lista.add(i);
        System.out.println("Lista: " + lista);
    }
}
