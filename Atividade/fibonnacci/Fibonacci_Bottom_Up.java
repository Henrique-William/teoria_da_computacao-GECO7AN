import java.sql.Time;

public class Fibonacci_Bottom_Up {
    public static int fib(int n) {
        if(n <= 1) return n;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            System.out.println("Laço de calculo... calculando " + i);
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println("Tabulação "+ dp);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Digite o número que deseja calcular o Fibonacci: ");
        int n = new java.util.Scanner(System.in).nextInt();

        Time inicio = new Time(System.currentTimeMillis());
        System.out.println("Fibonacci de " + n + ": " + fib(n));
        Time fim = new Time(System.currentTimeMillis());

        System.out.println("Inicio: " + inicio);
        System.out.println("Fim: " + fim);
        System.out.println("Tempo de execução: " + (fim.getTime() - inicio.getTime()) + "ms");
    }
}