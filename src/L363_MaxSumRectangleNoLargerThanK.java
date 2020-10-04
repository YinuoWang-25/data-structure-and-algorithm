// 363. Max Sum of Rectangle No Larger Than K

import java.util.TreeSet;

public class L363_MaxSumRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) return 0;
        int ret = Integer.MIN_VALUE, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < col; ++i) {
            for (int j = i; j < col; ++j) {
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int curSum = 0, curMax = Integer.MIN_VALUE;
                for (int[] ints : matrix) {
                    curSum += ints[j] - (i >= 1 ? ints[i - 1] : 0);
                    Integer it = sumSet.ceiling(curSum - k);
                    if (it != null) curMax = Math.max(curMax, curSum - it);
                    sumSet.add(curSum);
                }
                ret = Math.max(ret, curMax);
            }
        }
        return ret;
    }
}
