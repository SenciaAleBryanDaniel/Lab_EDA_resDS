package Lab09_Hashing.Ejr_ProbPropuestos.Ejercicio_03;

@SuppressWarnings("unchecked")
public class HashClosed<E> {

    private final Register<E>[] table;
    private final boolean[] deleted;
    private final int capacity;
    private int size;

    public HashClosed(int capacity) {
        this.capacity = capacity;
        this.table = new Register[capacity];
        this.deleted = new boolean[capacity];
        this.size = 0;
    }

    private int hash(int key) {
        int h = key % capacity;
        return (h < 0) ? h + capacity : h;
    }

    public boolean insert(int key, E value) {
        if (size == capacity) return false;

        int idx = hash(key);
        Integer posDeleted = null;

        for (int i = 0; i < capacity; i++) {
            int pos = (idx + i) % capacity;

            if (table[pos] == null) {
                int insertPos = (posDeleted != null) ? posDeleted : pos;
                table[insertPos] = new Register<>(key, value);
                deleted[insertPos] = false;
                size++;
                return true;
            }
            if (deleted[pos] && posDeleted == null) {
                posDeleted = pos;
            } else if (table[pos].getKey() == key) {
                return false;
            }
        }
        return false;
    }

    public E search(int key) {
        int idx = hash(key);
        for (int i = 0; i < capacity; i++) {
            int pos = (idx + i) % capacity;
            if (table[pos] == null && !deleted[pos]) break;
            if (table[pos] != null && table[pos].getKey() == key && !deleted[pos]) {
                return table[pos].getValue();
            }
        }
        return null;
    }

    public boolean delete(int key) {
        int idx = hash(key);
        for (int i = 0; i < capacity; i++) {
            int pos = (idx + i) % capacity;
            if (table[pos] == null && !deleted[pos]) break;
            if (table[pos] != null && table[pos].getKey() == key && !deleted[pos]) {
                table[pos] = null;
                deleted[pos] = true;
                size--;
                return true;
            }
        }
        return false;
    }

    public void show() {
        System.out.println("----  Tabla Hash Cerrada  ----");
        for (int i = 0; i < capacity; i++) {
            System.out.printf("[%02d] ", i);
            if (table[i] != null) {
                System.out.println(table[i]);
            } else if (deleted[i]) {
                System.out.println("eliminado");
            } else {
                System.out.println("--");
            }
        }
        System.out.println("------------------------------\n");
    }

    public int size() { return size; }
}
