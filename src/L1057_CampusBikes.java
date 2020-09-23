// 1057. Campus Bikes

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class L1057_CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                pq.offer(new int[]{i, j, getDis(workers[i], bikes[j])});
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        int size = res.length;
        Set<Integer> set = new HashSet<>();
        while (size > 0) {
            int[] cur = pq.poll();
            if (res[cur[0]] != -1) continue;
            if (set.contains(cur[1])) continue;
            res[cur[0]] = cur[1];
            set.add(cur[1]);
            size--;
        }
        return res;


    }

    private int getDis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
