// 494. Target Sum

public class L494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(S) > Math.abs(sum)) return 0;
        int[][] dp = new int[nums.length][sum * 2 + 1];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < (sum * 2 + 1); j++) {
                int l = (j - nums[i]) >= 0 ? dp[i - 1][j - nums[i]] : 0;
                int r = (j + nums[i]) < (sum * 2 + 1) ? dp[i - 1][j + nums[i]] : 0;
                dp[i][j] = l + r;
            }
        }
        return dp[nums.length - 1][sum + S];
    }
}
