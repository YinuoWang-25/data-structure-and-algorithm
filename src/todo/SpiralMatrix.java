package todo;

public class SpiralMatrix {
    // 54. Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int i = 0, j = 0;
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (j = left; j <= right && up <= down; j++) {
                result.add(matrix[up][j]);
            }
            up++;

            for (i = up; i <= down && left <= right; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            for (j = right; j >= left && up <= down; j--) {
                result.add(matrix[down][j]);
            }
            down--;

            for (i = down; i >= up && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;

    }
}
