package todo;
// 486. Predict the Winner

public class L486_PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 2; len <= nums.length; len++) {
            for (int s = 0; s < nums.length - len + 1; s++) {
                int e = s + len - 1;
                // if take i: dp[i + 1][j] player 2 get
                dp[s][e] = Math.max(nums[s] - dp[s + 1][e], nums[e] - dp[s][e - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
