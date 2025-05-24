package Lab03_Poo_herencia_interfaz_genericidad.Ejr_ProbPropuestos;

/**
 * Ejercicio 01 – Lista genérica enlazada simple.
 * implementado lo pedido en la guia.
 */
public class Ejercicio01PP {

    //nodo generico
    static class Node<T> {
        T data;           // valor almacenado
        Node<T> next;     // referencia al siguiente nodo

        Node(T data) { this.data = data; }
    }

    // lista enlazada
    static class List<T> {
        private Node<T> root;   // primer nodo
        private int      size;  // cantidad de nodos

        public boolean isEmpty()            { return size == 0; }
        public int     size()               { return size; }
        public void    clear()              { root = null; size = 0; }

        public void add(T value) {
            Node<T> n = new Node<>(value);
            if (root == null) {
                root = n;
            } else {
                Node<T> it = root;
                while (it.next != null) it = it.next;
                it.next = n;
            }
            size++;
        }

        public void add(int index, T value) {
            checkAddBounds(index);
            if (index == 0) {
                Node<T> n = new Node<>(value);
                n.next = root;
                root = n;
            } else {
                Node<T> prev = nodeAt(index - 1);
                Node<T> n = new Node<>(value);
                n.next = prev.next;
                prev.next = n;
            }
            size++;
        }

        public T get(int index) {
            checkBounds(index);
            return nodeAt(index).data;
        }

        public T set(int index, T value) {
            checkBounds(index);
            Node<T> target = nodeAt(index);
            T old = target.data;
            target.data = value;
            return old;
        }

        public T remove(int index) {
            checkBounds(index);
            T removed;
            if (index == 0) {
                removed = root.data;
                root = root.next;
            } else {
                Node<T> prev = nodeAt(index - 1);
                removed = prev.next.data;
                prev.next = prev.next.next;
            }
            size--;
            return removed;
        }

        public boolean contains(T value) {
            for (Node<T> it = root; it != null; it = it.next)
                if (value == null ? it.data == null : value.equals(it.data))
                    return true;
            return false;
        }

        private Node<T> nodeAt(int index) {
            Node<T> it = root;
            for (int i = 0; i < index; i++) it = it.next;
            return it;
        }
        private void checkBounds(int index) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Índice: " + index + ", tamaño: " + size);
        }
        private void checkAddBounds(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Índice: " + index + ", tamaño: " + size);
        }

        @Override public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (Node<T> it = root; it != null; it = it.next) {
                sb.append(it.data);
                if (it.next != null) sb.append(", ");
            }
            return sb.append("]").toString();
        }
    }

    //probando 
    public static void main(String[] args) {
        List<String> nombres = new List<>();

        nombres.add("Erika");
        nombres.add("Sandro");
        nombres.add("Daniela");
        System.out.println("Lista inicial: " + nombres);    

        nombres.add(1, "Alessandro");
        System.out.println("Tras insertar índice 1: " + nombres);     

        nombres.remove(2);
        System.out.println("Tras eliminar índice 2: " + nombres);     

        System.out.println("Contiene 'Esteven':" + nombres.contains("Esteven")); 
        System.out.println("Tamaño:" + nombres.size());     
    }
}
