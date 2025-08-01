package Lab09_Hashing.Ejr_ProbResDocente.ImpHash_Abierto;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class HashOpened<E> {

    private LinkedList<Register<E>>[] table;   

    public HashOpened(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(Register<E> reg) {
        int index = hash(reg.getKey());

        for (Register<E> r : table[index]) {
            if (r.getKey() == reg.getKey() && !r.isDeleted()) {
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
        }

        table[index].add(reg);
        System.out.println("Insertado: " + reg);
    }

    public void delete(int key) {
        int index = hash(key);
        for (Register<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                r.delete();                         
                System.out.println("Eliminado lógicamente: " + key);
                return;
            }
        }
        System.out.println("Clave no encontrada: " + key);
    }

    public Register<E> search(int key) {
        int index = hash(key);
        for (Register<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                return r;
            }
        }
        return null;
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Abierto) ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("[VACÍO]");
            } else {
                for (Register<E> r : table[i]) {
                    System.out.print(r + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}

