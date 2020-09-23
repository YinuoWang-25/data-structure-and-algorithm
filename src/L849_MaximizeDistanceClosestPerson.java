// 849. Maximize Distance to Closest Person

/**
 * 1. We have a variable to maintain the last occupied seat. Initialize as -1
 * 2. For loop seats, for every seats, we get the middle of this seats and previous seats dist: (cur - prev) / 2
 * 3. get max of res and dist
 * corner cases (no need to get (cur - prev) / 2):
 * a. if first seat is empty, we can try to assign it and get the max dist
 * b. if last seat is empty, we can try to assign it and get the max dist
 */

public class L849_MaximizeDistanceClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }
}
