import java.sql.Time;
import java.util.*;

public class Exercicio02 {
    static class Item {
        int peso, valor;
        Item(int p, int v) {
            peso = p;
            valor = v;
        }
        public String toString() {
            return "Peso = " + peso + ", Valor = " + valor;
        }
    }

    static List<Item> gerarItensFixos() {
        return Arrays.asList(
                new Item(5, 12),
                new Item(3, 10),
                new Item(5, 20),
                new Item(2, 15),
                new Item(4, 22)
        );
    }

    static List<Item> reconstruir(List<Item> itens, int[][] dp, int W) {
        List<Item> res = new ArrayList<>();
        for (int i = itens.size(), w = W; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = itens.get(i - 1);
                res.add(item);
                w -= item.peso;
            }
        }
        return res;
    }

    static int[][] mochilaDP(List<Item> itens, int W) {
        int n = itens.size();
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            Item item = itens.get(i - 1);
            for (int w = 0; w <= W; w++)
                dp[i][w] = (item.peso > w) ? dp[i - 1][w] : Math.max(dp[i - 1][w], dp[i - 1][w - item.peso] + item.valor);
        }
        return dp;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o limite de peso da mochila: ");
        int W = sc.nextInt();

        Time inicio = new Time(System.currentTimeMillis());
        List<Item> itens = gerarItensFixos();
        System.out.println("\nItens disponíveis:");
        itens.forEach(i -> System.out.println("Item: " + i));

        int[][] dp = mochilaDP(itens, W);
        List<Item> escolhidos = reconstruir(itens, dp, W);

        System.out.println("\nItens escolhidos:");
        escolhidos.forEach(i -> System.out.println("Item: " + i));

        Time fim = new Time(System.currentTimeMillis());
        System.out.println("\nValor total: " + dp[itens.size()][W]);
        System.out.println("Inicio: " + inicio);
        System.out.println("Fim: " + fim);
        System.out.println("Tempo de execução: " + (fim.getTime() - inicio.getTime()) + "ms");
    }
}
