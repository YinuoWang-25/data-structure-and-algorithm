// 296. Best Meeting Point

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L296_BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        return getMin(X) + getMin(Y);
    }

    private int getMin(List<Integer> nums) {
        Collections.sort(nums);
        int res = 0;
        int mid = nums.get(nums.size() / 2);
        for (int n : nums) {
            res += Math.abs(n - mid);
        }
        return res;
    }
}
