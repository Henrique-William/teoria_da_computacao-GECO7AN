import java.sql.Time;
import java.util.HashMap;

public class Fibonacci {
    public static int fib(int n, HashMap<Integer, Integer> memoria) {
        System.out.println("Calculando fib(" + n + ")");

        if(memoria.containsKey(n)) {
            System.out.println("Memoria: " + memoria);
            System.out.println("Retorno da memoria" + memoria.get(n));
            return memoria.get(n);
        };

        if(n <= 1) return n;

        int resultado = fib(n-1, memoria) + fib(n-2, memoria);
        memoria.put(n, resultado);

        return resultado;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n;

        HashMap<Integer, Integer> memoria = new HashMap<>();

        System.out.print("Enter a number: ");
        n = new java.util.Scanner(System.in).nextInt();
        Time inicio = new Time(System.currentTimeMillis());
        System.out.println("Fibonacci of " + n + " is: " + fibonacci.fib(n, memoria));
        Time fim = new Time(System.currentTimeMillis());

        System.out.println("Inicio: " + inicio);
        System.out.println("Fim: " + fim);
        System.out.println("Tempo de execução: " + (fim.getTime() - inicio.getTime()) + "ms");
        System.out.println("Tamanho da memoria utilizada: " + memoria.size() + " bytes");
    }
}