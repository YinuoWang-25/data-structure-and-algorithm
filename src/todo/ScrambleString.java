package todo;

public class ScrambleString {
    // 87. Scramble String
    public boolean isScramble(String s1, String s2) {
        int size = s1.length();
        if (s1.length() != s2.length()) {
            return false;
        }
        // edge case: diff char set
        char[] sortS1 = s1.toCharArray();
        Arrays.sort(sortS1);
        char[] sortS2 = s2.toCharArray();
        Arrays.sort(sortS2);
        if (!Arrays.equals(sortS1, sortS2)) {
            return false;
        }

        boolean[][][] dp = new boolean[size + 1][size][size];
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                if (s1.charAt(j) == s2.charAt(k)) {
                    dp[1][j][k] = true;
                }
            }
        }

        for (int n = 2; n <= size; n++) {
            for (int i = 0; i <= size - n; i++) {
                for (int j = 0; j <= size - n; j++) {
                    for (int k = 1; k < n; k++) {
                        if (dp[k][i][j] && dp[n - k][i + k][j + k] ||
                                dp[k][i][j + n - k] && dp[n - k][i + k][j]) {
                            dp[n][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[size][0][0];
    }
}
