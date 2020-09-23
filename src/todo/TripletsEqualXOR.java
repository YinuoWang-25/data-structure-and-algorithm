package todo;

public class TripletsEqualXOR {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0 ; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = dp[i][j-1] ^ arr[j];
            }
        }
        int ans = 0;
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (dp[i][j - 1] == dp[j][k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
