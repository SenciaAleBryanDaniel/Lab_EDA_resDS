package Lab03_Poo_herencia_interfaz_genericidad.Ejr_ProbResDocente;

//Clase animal en java

import java.util.ArrayList;
import java.util.List;

public class Ejercicio03RD {

    // lo volvemos statico para usarlo desde el main
    public static class Animal {
        String nombre;
        boolean genero;

        public Animal(String nombre, boolean genero) {
            this.nombre = nombre;
            this.genero = genero;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public boolean isGenero() {
            return genero;
        }

        public void setGenero(boolean genero) {
            this.genero = genero;
        }
    }

    public static void main(String[] args) {
        ArrayList<Animal> mascotas = new ArrayList<Animal>();
        List<Animal> mascotas2 = new ArrayList<Animal>(); 
        /*List<Animal> mascotas2 = new List<Animal>(); <- Ver error 
        no se puede instanciar debido a q List es una interfaz en java
        */
        // Agregar elementos y mostrar comportamiento
        mascotas.add(new Animal("Lucas", true));
        mascotas.add(new Animal("Luna", false));

        for (Animal a : mascotas) {
            System.out.println("Nombre: " + a.getNombre() + " y es: " + (a.isGenero() ? "Macho" : "Hembra"));
        }
    }
}
