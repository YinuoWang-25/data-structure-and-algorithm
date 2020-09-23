// 53. Maximum Subarray

public class L53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2] + nums[i], nums[i]);
            ans = Math.max(dp[i % 2], ans);
        }
        return ans;
    }
}
