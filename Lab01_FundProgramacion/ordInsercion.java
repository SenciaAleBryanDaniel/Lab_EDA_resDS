import java.util.Scanner;

public class ordInsercion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos elementos? ");
        int N = sc.nextInt();
        int[] a = new int[N];
        System.out.println("Ingresa los " + N + " números:");
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i < N; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        System.out.println("Arreglo ordenado:");
        for (int v : a) {
            System.out.print(v + " ");
        }
        System.out.println();
        sc.close();
    }
}
