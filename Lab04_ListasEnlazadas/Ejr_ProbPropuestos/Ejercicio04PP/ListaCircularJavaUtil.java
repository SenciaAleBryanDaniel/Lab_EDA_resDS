package Lab04_ListasEnlazadas.Ejr_ProbPropuestos.Ejercicio04PP;

/* Implementar una lista circular que tenga los elementos del 1 al 12 
utilizando la librería java.util. */

import java.util.LinkedList;

public class ListaCircularJavaUtil {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 1; i <= 12; i++) lista.add(i);

        int pasos = 13;                 
        int size  = lista.size();
        int idx   = 0;

        System.out.print("Recorrido circular: ");
        for (int i = 0; i < pasos; i++) {
            System.out.print(lista.get(idx) + " ");
            idx = (idx + 1) % size;     
        }
        System.out.println();
    }
}