import java.util.Arrays;
import java.util.Scanner;

class gestCalEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos estudiantes? ");
        int N = sc.nextInt();

        double[] notas = new double[N];
        System.out.println("Ingresa las " + N + " calificaciones:");
        for (int i = 0; i < N; i++) {
            notas[i] = sc.nextDouble();
        }

        double suma = 0;
        for (double n : notas) suma += n;
        double promedio = suma / N;

        Arrays.sort(notas);

        double mediana;
        if (N % 2 == 1) {
            mediana = notas[N / 2];
        } else {
            mediana = (notas[N/2 - 1] + notas[N/2]) / 2;
        }

        int maxCount = 1, count = 1, modeIndex = -1;
        for (int i = 1; i < N; i++) {
            if (notas[i] == notas[i-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                modeIndex = i;
            }
        }
        boolean hayModa = maxCount > 1;
        double moda = hayModa ? notas[modeIndex] : 0;

        double suma2 = 0;
        for (double n : notas) {
            double d = n - promedio;
            suma2 += d * d;
        }
        double desviacion = Math.sqrt(suma2 / N);

        System.out.printf("Mediana: %.2f%n", mediana);
        if (hayModa) {
            System.out.printf("Moda: %.2f%n", moda);
        } else {
            System.out.println("Moda: (no hay moda)");
        }
        System.out.printf("Desviación estándar: %.2f%n", desviacion);

        sc.close();
    }
}
