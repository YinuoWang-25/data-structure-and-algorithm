// 417. Pacific Atlantic Water Flow

import java.util.ArrayList;
import java.util.List;

public class L417_PacificAtlanticWaterFlow {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] Pacific = new boolean[n][m];
        boolean[][] Atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, Pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, Atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, Pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, Atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Pacific[i][j] && Atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] < height || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            dfs(matrix, visited, matrix[x][y], x + dx[i], y + dy[i]);
        }
    }
}
