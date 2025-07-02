package Lab07_ArbolBinarioAVL_Balanceado.EjrProbPropuestos.Ejercicio02;

public class AVLTree<T extends Comparable<T>> {

    private NodeAVL<T> root;

    public AVLTree() {
        root = null;
    }

    public void destroy() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int height(NodeAVL<T> n) {
        return n == null ? 0 : n.height;
    }

    private int getBalance(NodeAVL<T> n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    private NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        NodeAVL<T> T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        NodeAVL<T> T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void insert(T key) {
        root = insert(root, key);
    }

    private NodeAVL<T> insert(NodeAVL<T> node, T key) {
        if (node == null)
            return new NodeAVL<>(key);
        if (key.compareTo(node.data) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.data) > 0)
            node.right = insert(node.right, key);
        else 
            return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && key.compareTo(node.left.data) < 0)
            return rotateRight(node);
        if (balance < -1 && key.compareTo(node.right.data) > 0)
            return rotateLeft(node);
        if (balance > 1 && key.compareTo(node.left.data) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && key.compareTo(node.right.data) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void remove(T key) {
        root = remove(root, key);
    }

    private NodeAVL<T> remove(NodeAVL<T> node, T key) {
        if (node == null) return null;
        if (key.compareTo(node.data) < 0)
            node.left = remove(node.left, key);
        else if (key.compareTo(node.data) > 0)
            node.right = remove(node.right, key);
        else {
            if (node.left == null || node.right == null) {
                NodeAVL<T> temp = (node.left != null) ? node.left : node.right;
                if (temp == null) { node = null; }
                else { node = temp; }
            } else {
                NodeAVL<T> temp = minNode(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }
        if (node == null) return null;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left) >= 0)
            return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return rotateLeft(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public boolean search(T key) {
        return search(root, key);
    }

    private boolean search(NodeAVL<T> node, T key) {
        if (node == null) return false;
        int cmp = key.compareTo(node.data);
        if (cmp == 0) return true;
        return cmp < 0 ? search(node.left, key) : search(node.right, key);
    }

    public T Min() {
        return root == null ? null : minNode(root).data;
    }

    private NodeAVL<T> minNode(NodeAVL<T> node) {
        NodeAVL<T> current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    public T Max() {
        return root == null ? null : maxNode(root).data;
    }

    private NodeAVL<T> maxNode(NodeAVL<T> node) {
        NodeAVL<T> current = node;
        while (current.right != null) current = current.right;
        return current;
    }

    public T Predecesor(T key) {
        NodeAVL<T> pred = null, curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.data);
            if (cmp > 0) {
                pred = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return pred == null ? null : pred.data;
    }

    public T Sucesor(T key) {
        NodeAVL<T> succ = null, curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.data);
            if (cmp < 0) {
                succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return succ == null ? null : succ.data;
    }

    public void InOrder() { inOrder(root); System.out.println(); }
    private void inOrder(NodeAVL<T> n) {
        if (n != null) {
            inOrder(n.left);
            System.out.print(n.data + " ");
            inOrder(n.right);
        }
    }

    public void PreOrder() { preOrder(root); System.out.println(); }
    private void preOrder(NodeAVL<T> n) {
        if (n != null) {
            System.out.print(n.data + " ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void PostOrder() { postOrder(root); System.out.println(); }
    private void postOrder(NodeAVL<T> n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            System.out.print(n.data + " ");
        }
    }
}
