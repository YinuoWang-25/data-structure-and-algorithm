// 1. Two Sum

import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (hash.containsKey(target - nums[i])) {
                result[0] = hash.get(target - nums[i]);
                result[1] = i;
                break;
            }
            hash.put(nums[i], i);
        }
        return result;
    }
}
