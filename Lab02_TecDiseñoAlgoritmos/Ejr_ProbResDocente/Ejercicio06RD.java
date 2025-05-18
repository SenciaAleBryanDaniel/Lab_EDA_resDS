package Lab02_TecDiseñoAlgoritmos.Ejr_ProbResDocente;

//Implementar un método recursivo para ordenar los elementos de un vector.

public class Ejercicio06RD {
    static int[] vec = { 312, 614, 88, 22, 54 };
    
    void ordenar(int[] v, int cant) {
        if (cant > 1) {
            for (int f = 0; f < cant - 1; f++)
                if (v[f] > v[f + 1]) {
                    int aux = v[f];
                    v[f] = v[f + 1];
                    v[f + 1] = aux;
                }
            ordenar(v, cant - 1);
        }
    }

    void imprimir() {
        for (int f = 0; f < vec.length; f++)
            System.out.print(vec[f] + " ");
            System.out.println("\n");
    }
    public static void main(String[] ar) {
        Ejercicio06RD r = new Ejercicio06RD();
        r.imprimir();
        r.ordenar(vec, vec.length);
        r.imprimir();
    }

}
