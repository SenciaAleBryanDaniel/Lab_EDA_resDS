package Lab03_Poo_herencia_interfaz_genericidad.Ejr_ProbResDocente;

//Iterador

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio02RD {
    public static void main(String[] args){
        List<String> alumnos = new ArrayList<>();
        
        alumnos.add("MARIA");
        alumnos.add("DIEGO");
        alumnos.add("RENE");
        alumnos.add("ALONSO");

        Iterator<String> itA = alumnos.iterator();
        //imprime cada elemento 
        while (itA.hasNext()) {
            System.out.println(itA.next());
        }
    }
}