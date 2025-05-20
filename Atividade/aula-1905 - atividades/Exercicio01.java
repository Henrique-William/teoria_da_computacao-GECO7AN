import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio01 {
    public static int menorNumeroDeMoedas(int[] moedas, int valor) {
        int MAX = valor + 1;
        int[] dp = new int[valor + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 1; i <= valor; i++) {
            for (int moeda : moedas) {
                if (moeda <= i) {
                    dp[i] = Math.min(dp[i], dp[i - moeda] + 1);
                }
            }
        }

        return dp[valor] == MAX ? -1 : dp[valor];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time inicio = new Time(System.currentTimeMillis());
        int[] moedas = {1, 5, 10, 25};
        System.out.print("Digite o valor N que deseja atingir: ");
        int valor = scanner.nextInt();

        int resultado = menorNumeroDeMoedas(moedas, valor);
        if (resultado == -1) {
            System.out.println("Não é possível formar o valor com as moedas disponíveis.");
        } else {
            System.out.println("Menor número de moedas necessário: " + resultado);
        }
        Time fim = new Time(System.currentTimeMillis());
        System.out.println("Inicio: " + inicio);
        System.out.println("Fim: " + fim);
        System.out.println("Tempo de execução: " + (fim.getTime() - inicio.getTime()) + "ms");
        scanner.close();
    }
}
