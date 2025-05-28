public class Exercicio05 {

    public static void main(String[] args) {
        int[] vetor = {38, 27, 43, 3, 9, 82, 10, 5, 15, 0, 100, 99, 8, 7, 6, 1};

        System.out.println("Vetor original:");
        imprimirVetor(vetor);

        mergeSortHibrido(vetor, 0, vetor.length - 1, 16);

        System.out.println("\nVetor ordenado:");
        imprimirVetor(vetor);
    }

    public static void mergeSortHibrido(int[] vetor, int inicio, int fim, int limiar) {
        if (fim - inicio + 1 < limiar) {
            System.out.printf("QuickSort na partição [%d, %d]\n", inicio, fim);
            quickSort(vetor, inicio, fim);
        } else if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            System.out.printf("Dividindo [%d, %d] em [%d, %d] e [%d, %d] usando MergeSort\n",
                    inicio, fim, inicio, meio, meio + 1, fim);
            mergeSortHibrido(vetor, inicio, meio, limiar);
            mergeSortHibrido(vetor, meio + 1, fim, limiar);
            System.out.printf("Mesclando [%d, %d] e [%d, %d]\n", inicio, meio, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(vetor, inicio, fim);
            System.out.printf("Pivô escolhido: %d na posição %d\n", vetor[pivo], pivo);
            quickSort(vetor, inicio, pivo - 1);
            quickSort(vetor, pivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
                System.out.printf("Trocando %d e %d => ", vetor[j], vetor[i]);
                imprimirVetor(vetor);
            }
        }
        trocar(vetor, i + 1, fim);
        System.out.printf("Trocando %d e %d (pivô) => ", vetor[fim], vetor[i + 1]);
        imprimirVetor(vetor);
        return i + 1;
    }

    // Merge
    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        System.arraycopy(vetor, inicio, esquerda, 0, n1);
        System.arraycopy(vetor, meio + 1, direita, 0, n2);

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k++] = esquerda[i++];
            } else {
                vetor[k++] = direita[j++];
            }
        }

        while (i < n1) {
            vetor[k++] = esquerda[i++];
        }

        while (j < n2) {
            vetor[k++] = direita[j++];
        }
        System.out.print("Resultado da mesclagem: ");
        imprimirVetor(vetor);
    }

    public static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void imprimirVetor(int[] vetor) {
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

}
