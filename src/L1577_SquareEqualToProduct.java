// 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers

import java.util.HashMap;
import java.util.Map;

public class L1577_SquareEqualToProduct {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> set1 = new HashMap<>();
        for (int num : nums1) {
            set1.put((long) num * (long) num, set1.getOrDefault((long) num * (long) num, 0) + 1);
        }
        int res = 0;
        res = getRes(nums2, set1, res);

        Map<Long, Integer> set2 = new HashMap<>();
        for (int num : nums2) {
            set2.put((long) num * (long) num, set2.getOrDefault((long) num * (long) num, 0) + 1);
        }
        res = getRes(nums1, set2, res);
        return res;
    }

    private int getRes(int[] nums2, Map<Long, Integer> set1, int res) {
        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (set1.containsKey((long) nums2[i] * (long) nums2[j])) {
                    res += set1.get((long) nums2[i] * (long) nums2[j]);
                }
            }
        }
        return res;
    }
}
