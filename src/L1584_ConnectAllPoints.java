// 1584. Min Cost to Connect All Points

import java.util.*;

public class L1584_ConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(points.length, Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        int res = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (set.contains(cur[0])) continue;
            set.add(cur[0]);
            map.put(cur[0], cur[1]);
            res += cur[1];
            for (int i = 0; i < points.length; i++) {
                if (i == cur[0]) continue;
                int dist = Math.abs(points[i][0] - points[cur[0]][0]) + Math.abs(points[i][1] - points[cur[0]][1]);
                if (!map.containsKey(i) || dist < map.get(i)) {
                    map.put(i, dist);
                    pq.offer(new int[]{i, dist});
                }
            }
        }
        return res;
    }
}
