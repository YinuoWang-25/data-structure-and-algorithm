// 452. Minimum Number of Arrows to Burst Balloons
/*
    We can solve it in greedy way. Every time we cut the end position for a balloon
    and all overlap one could be cut as well

    In this way, we need to sort Balloons by their end position
 */

import java.util.Arrays;
import java.util.Comparator;

public class L452_MinimumNumberArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int last = points[0][1];
        int cut = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > last) {
                cut++;
                last = points[i][1];
            }
        }
        return cut;
    }
}
