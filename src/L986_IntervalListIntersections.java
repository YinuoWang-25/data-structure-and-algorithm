// 986. Interval List Intersections

import java.util.ArrayList;
import java.util.List;

public class L986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if (a[1] < b[0]) i++;
            else if (a[0] > b[1]) j++;
            else {
                res.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] > b[1]) j++;
                else i++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
