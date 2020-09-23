// 939. Minimum Area Rectangle
/**
 * 1. Create a map to group all y according to x
 * 2. get all pairs of two point from points array, if they don't have same x or y:
 * a. check whether we can get two more poitns to build a Rectangle
 * b. compare and update global min value
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L939_MinimumAreaRectangle {
    public int minAreaRect(int[][] point) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : point) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < point.length - 1; i++) {
            for (int j = i + 1; j < point.length; j++) {
                if (point[i][0] == point[j][0] || point[i][1] == point[j][1]) continue;
                if (map.get(point[i][0]).contains(point[j][1]) &&
                        map.get(point[j][0]).contains(point[i][1])) {
                    int cur = Math.abs(point[i][0] - point[j][0]) * Math.abs(point[i][1] - point[j][1]);
                    res = Math.min(res, cur);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
