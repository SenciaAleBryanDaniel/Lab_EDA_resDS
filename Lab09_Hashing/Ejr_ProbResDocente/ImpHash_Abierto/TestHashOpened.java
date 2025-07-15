package Lab09_Hashing.Ejr_ProbResDocente.ImpHash_Abierto;

public class TestHashOpened {
    public static void main(String[] args) {

        HashOpened<String> tabla = new HashOpened<>(8);   // tamaño 8

        tabla.insert(new Register<>(5,  "Pepe"));
        tabla.insert(new Register<>(21, "Jesús"));
        tabla.insert(new Register<>(19, "Juan"));
        tabla.insert(new Register<>(16, "María"));
        tabla.insert(new Register<>(21, "DUPLICADO"));    // debe advertir duplicado

        tabla.showTable();  

        System.out.println("\nBuscar clave 5  => " + tabla.search(5));
        System.out.println("Buscar clave 21 => " + tabla.search(21));

        tabla.delete(21);   
        tabla.delete(100);  

        tabla.showTable();  
    }
}
