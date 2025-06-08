package Lab05_PilasColas.Ejr_ProbResDocente;

/* Implementar una Pila utilizando una clase StackList y una clase 
nodo e ingresar los elementos 1, 2, 3, 4, 5, 6, 7 y 8. De acuerdo 
a la implementación del marco teórico utilizando clases y métodos 
genéricos..  */

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
            System.out.println("La pila está vacía");
            return -1; 
        } else {
            int valor = cima.valor;
            cima = cima.siguiente;
            return valor;
        }
    }
    
    public int peek() {
        if (cima == null) {
            System.out.println("La pila está vacía");
            return -1;
        } else {
            return cima.valor;
        }
    }
    
    public boolean estaVacia() {
        return cima == null;
    }
}

public class Ejercicio01RD {
    public static void main(String[] args) {
        StackList pila = new StackList();
        
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);
        pila.push(7);
        pila.push(8);
        
        while (!pila.estaVacia()) {
            System.out.println("PILA");
            System.out.println("Elemento superior: " + pila.peek());
            System.out.println("Elemento a eliminar: " + pila.peek());

            pila.pop();
        }
    }
}
