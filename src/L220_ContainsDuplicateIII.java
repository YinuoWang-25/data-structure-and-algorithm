// 220. Contains Duplicate III

/*
We keep a sliding window for size k, and for these values, we put them in buckets and check
 */

import java.util.HashMap;
import java.util.Map;

public class L220_ContainsDuplicateIII {
    private int getID(int i, int w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        t++;
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int m = getID(nums[i], t);
            if (d.containsKey(m)) return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < t) return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < t) return true;
            d.put(m, nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], t));
        }
        return false;
    }
}
