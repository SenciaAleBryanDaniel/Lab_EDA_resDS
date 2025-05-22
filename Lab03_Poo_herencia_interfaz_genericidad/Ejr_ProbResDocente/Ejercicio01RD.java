package Lab03_Poo_herencia_interfaz_genericidad.Ejr_ProbResDocente;

//ArrayList
import java.util.ArrayList;
public class Ejercicio01RD {
    public static void main(String[] args){
    ArrayList<String> alumnos = new ArrayList<String>();
    ArrayList<Integer> notas = new ArrayList<Integer>();

    alumnos.add("MARIA");
    alumnos.add("DIEGO");
    alumnos.add("RENE");
    alumnos.add("ALONSO");

    System.out.println(alumnos.hashCode());//identificador del hash
    System.out.println(alumnos.isEmpty()); //identifica si la lista esta vacia

    }
}