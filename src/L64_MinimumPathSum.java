// 64. Minimum Path Sum

public class L64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[2][n];
        f[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) f[0][j] = f[0][j - 1] + grid[0][j];
                else if (j == 0) {
                    f[i % 2][j] = f[(i - 1) % 2][j] + grid[i][j];
                } else {
                    f[i % 2][j] = Math.min(f[(i - 1) % 2][j], f[i % 2][(j - 1)]) + grid[i][j];
                }
            }
        }
        return f[(m - 1) % 2][(n - 1)];
    }
}
