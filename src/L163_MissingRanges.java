// 163. Missing Ranges
/*
    We just need to iterate all ranges in nums

    Need to deal with corner case:
    1. nums[0] > lower
    2. nums[nums.length-1] < upper

 */

import java.util.ArrayList;
import java.util.List;

public class L163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(getRange(lower, upper));
            return result;
        }
        if (nums[0] > lower) {
            result.add(getRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            long diff = nums[i] - nums[i - 1];
            if (diff > 1) {
                result.add(getRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            result.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private String getRange(int from, int to) {
        if (from == to) return String.valueOf(from);
        else return from + "->" + to;
    }
}
