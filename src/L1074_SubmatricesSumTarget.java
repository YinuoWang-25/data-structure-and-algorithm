// 1074. Number of Submatrices That Sum to Target

import java.util.HashMap;
import java.util.Map;

public class L1074_SubmatricesSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                matrix[i][j] += matrix[i][j - 1];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int[] ints : matrix) {
                    cur += ints[j] - (i > 0 ? ints[i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
