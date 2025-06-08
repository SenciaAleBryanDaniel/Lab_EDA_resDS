package Lab05_PilasColas.Ejr_ProbPropuestos.Ejercicio01;

import Lab05_PilasColas.Ejr_ProbPropuestos.Ejercicio01.Nodo;

/*Implementar una Pila que tenga los elementos del 1 al 10, 
usando la clase nodo en java. */

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
}

public class Ejercicio01PP {
    public static void main(String[] args) {
        StackList pila = new StackList();
        
        for (int i = 1; i <= 10; i++) {
            pila.push(i);
        }
        
        while (!pila.isEmpty()) {
            System.out.println("Elemento en la cima: " + pila.top());
            pila.pop();
        }
    }
}



