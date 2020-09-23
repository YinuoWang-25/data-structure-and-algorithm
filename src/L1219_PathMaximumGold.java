// 1219. Path with Maximum Gold

public class L1219_PathMaximumGold {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j, new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return max;
    }


    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return 0;
        }
        if (grid[i][j] == 0) return 0;
        visited[i][j] = true;

        int ans = grid[i][j], max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            max = Math.max(max, dfs(grid, x, y, visited));
        }
        visited[i][j] = false;
        return ans + max;
    }
}
