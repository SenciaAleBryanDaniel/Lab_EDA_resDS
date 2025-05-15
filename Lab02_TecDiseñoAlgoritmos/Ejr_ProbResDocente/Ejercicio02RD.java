package Lab02_TecDiseñoAlgoritmos.Ejr_ProbResDocente;

/*Implementación de un método recursivo que reciba un 
parámetro de tipo entero y luego llame en forma recursiva 
con el valor del parámetro menos 1 */

public class Ejercicio02RD {

    public class Recursividad{
        void imprimir(int x){
            System.out.println(x);
            imprimir(x-1);
        }
    }

    public static void main(String[] args){
        Ejercicio02RD obj = new Ejercicio02RD();
        Recursividad re = obj.new Recursividad();
        re.imprimir(5);
    }

}
