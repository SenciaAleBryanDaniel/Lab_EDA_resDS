package Lab02_TecDiseñoAlgoritmos.Ejr_ProbResDocente;

// Imprimir los números de 1 a 5 en pantalla utilizando recursividad.

public class Ejercicio04RD {
    
    public class Recursividad{
        void imprimir(int x){
            if(x>0){
                imprimir(x-1);
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args){
        Ejercicio04RD obj = new Ejercicio04RD();
        Recursividad re = obj.new Recursividad();
        re.imprimir(5);
    }
    
}
