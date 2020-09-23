// 57. Insert Interval

import java.util.ArrayList;
import java.util.List;

public class L57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(new int[]{interval[0], interval[1]});
            } else if (interval[0] > newInterval[1]) {
                res.add(new int[]{newInterval[0], newInterval[1]});
                newInterval[0] = interval[0];
                newInterval[1] = interval[1];
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        res.add(new int[]{newInterval[0], newInterval[1]});
        return res.toArray(new int[res.size()][]);
    }
}
