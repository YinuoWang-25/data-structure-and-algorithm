package todo;

public class KnightProbabilityChessboard {
    // 688. Knight Probability in Chessboard
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dir = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for (int step = 1; step <= K; step++) {
            double[][] dpTemp = new double[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    for (int[] direction : dir) {
                        int lastR = i - direction[0];
                        int lastC = j - direction[1];
                        if (lastR >= 0 && lastR < N && lastC >= 0 && lastC < N)
                            dpTemp[i][j] += dp[lastR][lastC] * 0.125;
                    }
            dp = dpTemp;
        }
        double res = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                res += dp[i][j];

        return res;
    }
}
