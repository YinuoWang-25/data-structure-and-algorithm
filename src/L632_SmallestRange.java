// 632. Smallest Range Covering Elements from K Lists

import java.util.List;
import java.util.PriorityQueue;

/**
 * Intuition: same idea as merge K sorted arrays
 * Maintain a PriorityQueue which has one elem from per list
 * a. calculate current range and update global res
 * b. pop up the smallest value from PriorityQueue
 * c. Add the next element of the one poped up
 */
public class L632_SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(nums.size(), (a, b) -> (
                a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]
        ));
        int curMax = Integer.MIN_VALUE;
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{i, 0, nums.get(i).get(0)});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }
        while (pq.size() == nums.size()) {
            int[] cur = pq.poll();
            int range = curMax - cur[2];
            if (res[0] == -1 || (range < res[1] - res[0])) {
                res[0] = cur[2];
                res[1] = curMax;
            }
            if (nums.get(cur[0]).size() > cur[1] + 1) {
                int next = nums.get(cur[0]).get(cur[1] + 1);
                pq.offer(new int[]{cur[0], cur[1] + 1, next});
                curMax = Math.max(curMax, next);
            }
        }
        return res;
    }
}
