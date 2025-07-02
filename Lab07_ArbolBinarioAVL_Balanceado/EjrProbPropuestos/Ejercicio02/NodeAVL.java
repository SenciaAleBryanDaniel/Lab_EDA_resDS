package Lab07_ArbolBinarioAVL_Balanceado.EjrProbPropuestos.Ejercicio02;

public class NodeAVL<T extends Comparable<T>> {
    T data;
    NodeAVL<T> left, right;
    int height;

    public NodeAVL(T data) {
        this.data = data;
        this.left = this.right = null;
        this.height = 1;
    }
}
