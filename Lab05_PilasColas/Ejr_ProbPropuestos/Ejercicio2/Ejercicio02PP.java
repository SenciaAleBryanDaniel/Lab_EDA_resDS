package Lab05_PilasColas.Ejr_ProbPropuestos.Ejercicio2;

/* Implementar una Pila que tenga los elementos del 1 al 10, usando la clase nodo en java y los métodos vistos
en el marco teórico (push, pop, top, destroystak, isEmpty, isFull, printStack) y probar una clase Principal con
un menú de opciones para probar los métodos*/
import java.util.Scanner;

class Nodo {
    int valor;
    Nodo siguiente;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class StackList {
    Nodo cima;
    
    public StackList() {
        cima = null;
    }
    
    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }
    
    public int pop() {
        if (cima == null) {
            return -1;
        } else {
            int valor = cima.valor;
            cima = cima.siguiente;
            return valor;
        }
    }
    
    public int top() {
        if (cima == null) {
            return -1;
        } else {
            return cima.valor;
        }
    }
    
    public boolean isEmpty() {
        return cima == null;
    }
    
    public void destroyStack() {
        cima = null;
    }
    
    public void printStack() {
        Nodo temp = cima;
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}

public class Ejercicio02PP {
    public static void main(String[] args) {
        StackList pila = new StackList();
        Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i <= 10; i++) {
            pila.push(i);
        }
        
        int opcion;
        
        do {
            System.out.println("1. Mostrar Pila");
            System.out.println("2. Desapilar");
            System.out.println("3. Ver el tope");
            System.out.println("4. Verificar si la pila está vacía");
            System.out.println("5. Vaciar la pila");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    pila.printStack();
                    break;
                case 2:
                    System.out.println("Elemento desapilado: " + pila.pop());
                    break;
                case 3:
                    System.out.println("Elemento en la cima: " + pila.top());
                    break;
                case 4:
                    System.out.println("¿Está vacía? " + pila.isEmpty());
                    break;
                case 5:
                    pila.destroyStack();
                    System.out.println("Pila vaciada.");
                    break;
            }
        } while(opcion != 6);
        
        sc.close();
    }
}

