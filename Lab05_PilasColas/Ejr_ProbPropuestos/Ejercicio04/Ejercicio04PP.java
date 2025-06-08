package Lab05_PilasColas.Ejr_ProbPropuestos.Ejercicio04;

/* Implementar una Cola que tenga los elementos del 1 al 10, usando la clase nodo en java y los métodos vistos
en el marco teórico (encolar, desencolar, destroyQueue, isEmpty, isFull, front, back, printQueue) y probar
una clase Principal con un menú de opciones para probar los métodos.*/
import java.util.Scanner;

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
    
    public boolean isFull() {
        return false; 
    }
    
    public void destroyQueue() {
        frente = null;
        finalDeCola = null;
    }
    
    public void printQueue() {
        Nodo temp = frente;
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}

public class Ejercicio04PP {
    public static void main(String[] args) {
        QueueList cola = new QueueList();
        Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i <= 10; i++) {
            cola.enqueue(i);
        }
        
        int opcion;
        
        do {
            System.out.println("1. Mostrar Cola");
            System.out.println("2. Desencolar");
            System.out.println("3. Ver el frente");
            System.out.println("4. Verificar si la cola está vacía");
            System.out.println("5. Vaciar la cola");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    cola.printQueue();
                    break;
                case 2:
                    System.out.println("Elemento desencolado: " + cola.dequeue());
                    break;
                case 3:
                    System.out.println("Elemento al frente de la cola: " + cola.front());
                    break;
                case 4:
                    System.out.println("¿Está vacía? " + cola.isEmpty());
                    break;
                case 5:
                    cola.destroyQueue();
                    System.out.println("Cola vaciada.");
                    break;
            }
        } while(opcion != 6);
        
        sc.close();
    }
}
