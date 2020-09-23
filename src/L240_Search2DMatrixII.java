// 240. Search a 2D Matrix II

public class L240_Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;

        int n = matrix.length, m = matrix[0].length, x = n - 1, y = 0;

        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) y++;
            else if (matrix[x][y] > target) x--;
            else return true;
        }
        return false;
    }
}
