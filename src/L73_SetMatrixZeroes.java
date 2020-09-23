// 73. Set Matrix Zeroes

import java.util.Arrays;

public class L73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean zeroRow = false, zeroCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) zeroRow = true;
                    if (j == 0) zeroCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zeroRow) {
            Arrays.fill(matrix[0], 0);
        }
        if (zeroCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
