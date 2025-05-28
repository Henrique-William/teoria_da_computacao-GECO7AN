public class Exercicio02 {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 10, 1, 2, 4, 9, 7, 5};
        quickSort(arr, 0, arr.length - 1);

        // Imprime o array ordenado
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = hoarePartition(arr, low, high);
            quickSort(arr, low, p);
            quickSort(arr, p + 1, high);
        }
    }

    public static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            // Troca os elementos
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
