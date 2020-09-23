// 311. Sparse Matrix Multiplication

public class L311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, q = B[0].length;

        int[][] res = new int[m][q];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < q; k++) {
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
