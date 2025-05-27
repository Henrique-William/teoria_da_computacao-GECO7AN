
public class MergeSort {

    public static int[] mergeSort(int[] array) {

        System.out.println("Array entrado: " + java.util.Arrays.toString(array));
        
        if (array.length < 2) {
            return array;
        }

        int[] arrEsqueda = new int[array.length / 2];
        int[] arrDireita = new int[array.length - arrEsqueda.length];

        for (int i = 0; i < arrEsqueda.length; i++) {
            arrEsqueda[i] = array[i];
        }

        for (int i = 0; i < arrDireita.length; i++) {
            arrDireita[i] = array[i + arrEsqueda.length];
        }

        int tamArrayEsq = arrEsqueda.length;
        int tamArrayDir = arrDireita.length;

        System.out.println("Merge Sort array esquerda: " + tamArrayEsq);
        System.out.println("Merge Sort array direita: " + tamArrayDir);

        int[] resultado = new int[tamArrayEsq + tamArrayDir];
        int i = 0, j = 0, k = 0;

        while(i < tamArrayEsq && j < tamArrayDir) {
            System.out.println("Valor de i: " + i + ", Valor de j: " + j + ", Valor de k: " + k);
            System.out.println("Comparando " + arrEsqueda[i] + " e " + arrDireita[j]);

            if (arrEsqueda[i] <= arrDireita[j]) {
                resultado[k++] = arrEsqueda[i++];
            } else {
                resultado[k++] = arrDireita[j++];
            }

            System.out.println("Resultado parcial: " + java.util.Arrays.toString(resultado));

        }

        while (i < tamArrayEsq) {
            resultado[k++] = arrEsqueda[i++];
        }
        while (j < tamArrayDir) {
            resultado[k++] = arrDireita[j++];
        }

        return resultado;

    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array principal:" + java.util.Arrays.toString(array));

        int[] arrayOrdenado = mergeSort(array);
        System.out.println("Array ordenado:" + java.util.Arrays.toString(arrayOrdenado));
    }
}