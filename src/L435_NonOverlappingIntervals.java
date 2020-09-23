// 435. Non-overlapping Intervals

import java.util.Arrays;
import java.util.Comparator;

public class L435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] last = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= last[1]) {
                last = intervals[i];
            } else if (intervals[i][0] < last[1]) {
                count++;
                last[1] = Math.min(last[1], intervals[i][1]);
            }
        }
        return count;
    }
}
