public class Exercicio03 {

    public static int[][] strassen2x2(int[][] A, int[][] B) {
        int a = A[0][0], b = A[0][1];
        int c = A[1][0], d = A[1][1];
        int e = B[0][0], f = B[0][1];
        int g = B[1][0], h = B[1][1];

        int M1 = (a + d) * (e + h);
        int M2 = (c + d) * e;
        int M3 = a * (f - h);
        int M4 = d * (g - e);
        int M5 = (a + b) * h;
        int M6 = (c - a) * (e + f);
        int M7 = (b - d) * (g + h);

        System.out.println("M1 = " + M1);
        System.out.println("M2 = " + M2);
        System.out.println("M3 = " + M3);
        System.out.println("M4 = " + M4);
        System.out.println("M5 = " + M5);
        System.out.println("M6 = " + M6);
        System.out.println("M7 = " + M7);

        int C11 = M1 + M4 - M5 + M7;
        int C12 = M3 + M5;
        int C21 = M2 + M4;
        int C22 = M1 - M2 + M3 + M6;

        int[][] C = {
                { C11, C12 },
                { C21, C22 }
        };

        return C;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 3},
                {7, 5}
        };

        int[][] B = {
                {6, 8},
                {4, 2}
        };

        int[][] C = strassen2x2(A, B);

        System.out.println("\nMatriz C:");
        for (int i = 0; i < 2; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println("]");
        }
    }

}
