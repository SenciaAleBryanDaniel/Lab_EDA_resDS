package Lab02_TecDiseñoAlgoritmos.Ejr_ProbResDocente;

//Implementación de un método recursivo.

public class Ejercicio01RD {
    
    void repetir(){
        repetir();
    }

    public static void main(String[] args){
        Ejercicio01RD re = new Ejercicio01RD();
        re.repetir();
    }

}
