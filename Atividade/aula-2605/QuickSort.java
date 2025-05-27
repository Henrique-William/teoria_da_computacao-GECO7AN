public class QuickSort {

    public static void quickSort(int[] array, int inicio, int fim) {

        if (inicio < fim) {
            int pivo = particionar(array, inicio, fim);
            System.out.println("---> Entrando em QuickSort (chamada recursiva 1): "  + java.util.Arrays.toString(array) + ", inicio: " + inicio + ", fim: " + fim + ", pivo: " + pivo);
            quickSort(array, inicio, pivo - 1);

            System.out.println("---> Entrando em QuickSort (chamada recursiva 2): " + java.util.Arrays.toString(array) + ", inicio: " + inicio + ", fim: " + fim + ", pivo: " + pivo);
            quickSort(array, pivo + 1, fim);
        }

    }

    public static int particionar(int[] array, int inicio, int fim) {
        System.out.println("---> Particionando: " + java.util.Arrays.toString(array) + ", inicio: " + inicio + ", fim: " + fim + "array: " + array);
        int pivo = array[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            System.out.println("---------> Analisando elementos:  " + array[j] + " na posição "+ j + "pivo" + pivo);
            if (array[j] <= pivo) {
               trocar(array, i, j);
               i++;
                System.out.println("---------> Trocando elementos: " + array[i] + " e " + array[j] + ", novo array: " + java.util.Arrays.toString(array));
            }
        }

        if (array[i] > array[fim]) {
            System.out.println("--------- Foraçando troca de " + array[i] + " e " + array[fim]);
            trocar(array, i + 1, fim);
        }

        System.out.println("--------- Partição concluída: " + java.util.Arrays.toString(array) + ", novo pivo: " + (i + 1));

        return i;
    }

    public static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];A
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arrayEntrada = {8, 6, 45, 355, 23, 9, 7, 1, 3, 4, 10};
        System.out.println("Array principal: " + java.util.Arrays.toString(arrayEntrada));
        System.out.println("----------------------------------------------------------------");
        
        quickSort(arrayEntrada, 0, arrayEntrada.length - 1);

        System.out.println("Array ordenado: " + java.util.Arrays.toString(arrayEntrada));
    }

}