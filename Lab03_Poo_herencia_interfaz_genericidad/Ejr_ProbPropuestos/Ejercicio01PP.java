package Lab03_Poo_herencia_interfaz_genericidad.Ejr_ProbPropuestos;

/*Listas, Implementar una Lista usando POO con clases y métodos 
genéricos siguiendo los estándares de Java */

public class Ejercicio01PP {

    static class Node<T> {
        //tipo generico
        T data;
        // referencia al siguiente nodo
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // clase de tipo lista generica
    static class List<T> {
        Node<T> root; //referencia sobre el nodo inicial

        public List() {
            root = null;
        }
    }

    public static void main(String[] args) {
        List<String> lista = new List<>();
        //lista empieza con un nodo de valor "A"
        Node<String> nodo1 = new Node<>("A");
        Node<String> nodo2 = new Node<>("B");
        Node<String> nodo3 = new Node<>("C");
    
        lista.root = nodo1;
        nodo1.nextNode = nodo2;
        nodo2.nextNode = nodo3;

        if (lista.root != null) {
            System.out.println("Lista creada con nodos encadenados.");
        } else {
            System.out.println("Lista vacía.");
        }
    }
}
