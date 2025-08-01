//  Implementación de Nodo Genérico. 
public class Node<T> {
    private T data;
    private Node<T> left, right;

    public Node(T data) {
        this.data  = data;
        this.left  = this.right = null;
    }

    public T getData() { 
        return data; 
    }
    public void setData(T data) { 
        this.data = data; 
    }
    public Node<T> getLeft() { 
        return left; 
    }
    public void setLeft(Node<T> left) { 
        this.left = left; 
    }
    public Node<T> getRight() { 
        return right; 
    }
    public void setRight(Node<T> right) { 
        this.right = right; 
    }
}
