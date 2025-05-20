import java.sql.Time;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Exercicio03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o tamanho da matriz N x N: ");
        int n = scanner.nextInt();

        Time inicio = new Time(System.currentTimeMillis());
        int[][] matriz = gerarMatriz(n, 1, 9);

        System.out.println("\nMatriz gerada:");
        imprimirMatriz(matriz);


        int[][] dp = new int[n][n];
        int[][][] pai = new int[n][n][2];

        dp[0][0] = matriz[0][0];
        pai[0][0] = new int[] { -1, -1 };

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matriz[0][j];
            pai[0][j] = new int[] { 0, j - 1 };
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matriz[i][0];
            pai[i][0] = new int[] { i - 1, 0 };
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = matriz[i][j] + dp[i - 1][j];
                    pai[i][j] = new int[] { i - 1, j };
                } else {
                    dp[i][j] = matriz[i][j] + dp[i][j - 1];
                    pai[i][j] = new int[] { i, j - 1 };
                }
            }
        }

        ArrayList<Integer> caminhoValores = new ArrayList<>();
        int i = n - 1, j = n - 1;
        while (i != -1 && j != -1) {
            caminhoValores.add(matriz[i][j]);
            int[] anterior = pai[i][j];
            i = anterior[0];
            j = anterior[1];
        }
        Collections.reverse(caminhoValores);

        System.out.print("\nCaminho mínimo = ");
        for (int k = 0; k < caminhoValores.size(); k++) {
            System.out.print(caminhoValores.get(k));
            if (k < caminhoValores.size() - 1) System.out.print(" → ");
        }
        Time fim = new Time(System.currentTimeMillis());
        System.out.println(" = " + dp[n - 1][n - 1]);
        System.out.println("Inicio: " + inicio);
        System.out.println("Fim: " + fim);
        System.out.println("Tempo de execução: " + (fim.getTime() - inicio.getTime()) + "ms");
    }

    public static int[][] gerarMatriz(int n, int min, int max) {
        Random random = new Random();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }

        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }
}
