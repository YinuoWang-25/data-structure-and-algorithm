//152. Maximum Product Subarray

public class L152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minPre = nums[0], maxPre = nums[0], max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
            min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
            res = Math.max(res, max);
            maxPre = max;
            minPre = min;
        }
        return res;
    }
}
