// 218. The Skyline Problem

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class L218_TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }

        Collections.sort(points, (int[] a, int[] b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prevMax = 0;
        for (int[] h : points) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int curMax = pq.peek();
            if (prevMax != curMax) {
                List<Integer> curPoint = new ArrayList<>();
                curPoint.add(h[0]);
                curPoint.add(curMax);
                res.add(curPoint);
                prevMax = curMax;
            }
        }

        return res;
    }
}
