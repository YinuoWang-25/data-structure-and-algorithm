package todo;

public class GuessNumberHigherLowerII {
    // 375. Guess Number Higher or Lower II
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i  <= n + 1 - len ; i++) {
                int j = i + len - 1;
                // [i, j]
                dp[i][j] = i + dp[i + 1][j];
                dp[i][j] = Math.min(dp[i][j], j + dp[i][j - 1]);
                for (int b = i + 1; b < j; b++) {
                    // guess b
                    int tmp = Math.max(dp[i][b - 1], dp[b + 1][j]) + b;
                    dp[i][j] = Math.min(tmp, dp[i][j]);
                }
            }
        }
        return dp[1][n];
    }
}
