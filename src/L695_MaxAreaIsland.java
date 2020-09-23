// 695. Max Area of Island

public class L695_MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    ans = Math.max(ans, cur);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i, j + 1);
        num += dfs(grid, i, j - 1);
        return num;

    }
}
