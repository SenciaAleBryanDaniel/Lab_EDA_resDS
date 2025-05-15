package Lab02_TecDiseñoAlgoritmos.Ejr_ProbResDocente;

/* Implementar un método recursivo que imprima en forma 
descendente de 5 a 1 de uno en uno */
public class Ejercicio03RD {

    public class Recursividad{
        void imprimir(int x){
            if(x>0){
                System.out.println(x);
                imprimir(x-1);
            }
        }
    }
    public static void main(String[] args){
        Ejercicio03RD obj = new Ejercicio03RD();
        Recursividad re = obj.new Recursividad();
        re.imprimir(5);
    }

}
