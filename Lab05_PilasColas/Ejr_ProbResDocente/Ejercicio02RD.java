package Lab05_PilasColas.Ejr_ProbResDocente;

/*Ejercicio 2: Implementar una Cola utilizando una clase QueueList y una clase nodo e ingresar los elementos
1, 2, 3, 4, 5, 6, 7 y 8. De acuerdo a la implementación del marco teórico utilizando clases y métodos genéricos. */

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
            System.out.println("La cola está vacía");
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
    
    public int peek() {
        if (frente == null) {
            System.out.println("La cola está vacía");
            return -1;
        } else {
            return frente.valor;
        }
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
}

public class Ejercicio02RD {
    public static void main(String[] args) {
        QueueList cola = new QueueList();
        
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);
        cola.enqueue(6);
        cola.enqueue(7);
        cola.enqueue(8);
        
        while (!cola.estaVacia()) {
            System.out.println("Elemento al frente de la cola: " + cola.peek());
            cola.dequeue();
        }
    }
}
