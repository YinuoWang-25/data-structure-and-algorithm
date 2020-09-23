// 373. Find K Pairs with Smallest Sums

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class L373_FindKPairsSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            res.add(tmp);
            if (cur[2] == nums2.length - 1) continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
