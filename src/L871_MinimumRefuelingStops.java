// 871. Minimum Number of Refueling Stops
/*
We use a PriorityQueue to store the farthest station we can reach

Compare with jump game: This problem cares about the SUM, but jump game cares about single step
 */

import java.util.PriorityQueue;

public class L871_MinimumRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) return startFuel >= target ? 0 : -1;
        int n = stations.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0;
        while (startFuel < target) {
            while (i < n && startFuel >= stations[i][0]) {
                pq.offer(-stations[i++][1]);
            }
            if (pq.isEmpty()) return -1;
            startFuel -= pq.poll();
            res++;
        }

        return res;
    }
}
