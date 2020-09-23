// 322. Coin Change

import java.util.Arrays;

public class L322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int coin : coins) {
            if (coin < dp.length) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i > coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
