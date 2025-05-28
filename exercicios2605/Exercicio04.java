public class Exercicio04 {

    public static void ternaryMergeSort(int[] arr, int left, int right) {
        if (right - left <= 1) return; // base case: 0 ou 1 elemento

        int third = (right - left) / 3;
        int mid1 = left + third;
        int mid2 = left + 2 * third;

        if (mid2 >= right) mid2 = right - 1;

        ternaryMergeSort(arr, left, mid1);
        ternaryMergeSort(arr, mid1, mid2);
        ternaryMergeSort(arr, mid2, right);

        merge(arr, left, mid1, mid2, right);
    }

    private static void merge(int[] arr, int left, int mid1, int mid2, int right) {
        int[] temp = new int[right - left];
        int i = left, j = mid1, k = mid2, t = 0;

        while (i < mid1 || j < mid2 || k < right) {
            int minVal = Integer.MAX_VALUE;

            if (i < mid1) minVal = Math.min(minVal, arr[i]);
            if (j < mid2) minVal = Math.min(minVal, arr[j]);
            if (k < right) minVal = Math.min(minVal, arr[k]);

            if (i < mid1 && arr[i] == minVal) temp[t++] = arr[i++];
            else if (j < mid2 && arr[j] == minVal) temp[t++] = arr[j++];
            else if (k < right && arr[k] == minVal) temp[t++] = arr[k++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 5, 6, 4, 8, 2, 1};
        ternaryMergeSort(arr, 0, arr.length);
        System.out.println("Sorted: " + java.util.Arrays.toString(arr));
    }

}
