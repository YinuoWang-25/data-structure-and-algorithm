// 877. Stone Game

public class L877_StoneGame {

    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            dp[i][i] = piles[i];
            if (i > 0) {
                dp[i - 1][i] = Math.max(piles[i - 1], piles[i]);
            }
        }

        for (int len = 3; len <= piles.length; len++) {
            for (int i = 0; i + len - 1 < piles.length; i++) {
                dp[i][i + len - 1] = Math.max(piles[i] + dp[i + 1][i + len - 1], piles[i + len - 1] + dp[i][i + len - 2]);
            }
        }
        return dp[0][piles.length - 1] > sum / 2;
    }
}
