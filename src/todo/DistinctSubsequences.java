package todo;

public class DistinctSubsequences {
    // 115. Distinct Subsequences
    public int numDistinct(String S, String T) {
        int[][] mem = new int[T.length() + 1][S.length() + 1];
        for (int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                mem[i][j] = mem[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    mem[i][j] += mem[i - 1][j - 1];
                }
            }
        }

        return mem[T.length()][S.length()];
    }
}
