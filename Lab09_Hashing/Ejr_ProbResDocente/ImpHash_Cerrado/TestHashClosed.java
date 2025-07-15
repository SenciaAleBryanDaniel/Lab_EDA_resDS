package Lab09_Hashing.Ejr_ProbResDocente.ImpHash_Cerrado;

public class TestHashClosed {
    public static void main(String[] args) {

        HashClosed<String> hash = new HashClosed<>(11);   

        int[] claves = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        for (int k : claves) hash.insert(k, "A");

        hash.show(); 

        System.out.println("Buscar 32  => "
                           + (hash.search(32)  != null ? "encontrado"  : "NO encontrado"));
        System.out.println("Buscar 200 => "
                           + (hash.search(200) != null ? "encontrado"  : "NO encontrado"));
        System.out.println();

        hash.delete(17);
        hash.delete(100);

        hash.show();  
    }
}


