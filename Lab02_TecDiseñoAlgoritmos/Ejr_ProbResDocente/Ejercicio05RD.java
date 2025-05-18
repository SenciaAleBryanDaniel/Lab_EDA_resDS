package Lab02_TecDiseñoAlgoritmos.Ejr_ProbResDocente;

/*Obtener el factorial de un número. Recordar que el factorial 
de un número es el resultado que se obtiene de multiplicar 
dicho número por el anterior y así sucesivamente hasta llegar a uno.
Ej. el factorial de 4 es 4 * 3 * 2 * 1 es decir 24. */

public class Ejercicio05RD {
    
    int factorial(int fact) {
        if (fact > 0) {
            int valor = fact * factorial(fact - 1);
            return valor;
        } else
        return 1;
    }

    public static void main(String[] args) {
        Ejercicio05RD re = new Ejercicio05RD();
        int f = re.factorial(4);
        System.out.println("El factorial de 4 es " + f);
    }

}
