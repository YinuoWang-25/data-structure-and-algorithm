// 213. House Robber II

public class L213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int noRob1st = rob_helper(nums, 1, nums.length - 1);
        int rob1st = nums[0] + rob_helper(nums, 2, nums.length - 2);
        return Math.max(noRob1st, rob1st);
    }

    public int rob_helper(int[] nums, int start, int end) {
        if (end < start) {
            return 0;
        }
        int[][] dp = new int[2][2];
        dp[start % 2][0] = nums[start];
        dp[start % 2][1] = 0;
        for (int i = start + 1; i <= end; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][1] + nums[i];
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]);
        }
        return Math.max(dp[end % 2][0], dp[end % 2][1]);
    }
}
