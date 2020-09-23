// 56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        List<int[]> res = new ArrayList<>();
        int[] last = intervals[0];
        for (int[] interval : intervals) {
            if (interval[1] < last[0]) {
                res.add(new int[]{interval[0], interval[1]});
            } else if (interval[0] > last[1]) {
                res.add(new int[]{last[0], last[1]});
                last[0] = interval[0];
                last[1] = interval[1];
            } else {
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        res.add(new int[]{last[0], last[1]});
        return res.toArray(new int[res.size()][]);
    }
}
