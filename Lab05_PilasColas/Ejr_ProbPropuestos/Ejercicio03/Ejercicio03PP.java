package Lab05_PilasColas.Ejr_ProbPropuestos.Ejercicio03;

/* Implementar una Cola que tenga los elementos del 1 al 10, usando la clase nodo en java*/

class Nodo {
    int valor;
    Nodo siguiente;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class QueueList {
    Nodo frente;
    Nodo finalDeCola;
    
    public QueueList() {
        frente = null;
        finalDeCola = null;
    }
    
    public void enqueue(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (finalDeCola == null) {
            frente = nuevoNodo;
            finalDeCola = nuevoNodo;
        } else {
            finalDeCola.siguiente = nuevoNodo;
            finalDeCola = nuevoNodo;
        }
    }
    
    public int dequeue() {
        if (frente == null) {
            return -1;
        } else {
            int valor = frente.valor;
            frente = frente.siguiente;
            if (frente == null) {
                finalDeCola = null;
            }
            return valor;
        }
    }
    
    public int front() {
        if (frente == null) {
            return -1;
        } else {
            return frente.valor;
        }
    }
    
    public boolean isEmpty() {
        return frente == null;
    }
}

public class Ejercicio03PP {
    public static void main(String[] args) {
        QueueList cola = new QueueList();
        
        for (int i = 1; i <= 10; i++) {
            cola.enqueue(i);
        }
        
        while (!cola.isEmpty()) {
            System.out.println("Elemento al frente de la cola: " + cola.front());
            cola.dequeue();
        }
    }
}
