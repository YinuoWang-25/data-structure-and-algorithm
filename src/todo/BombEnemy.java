package todo;

public class BombEnemy {
    // 361. Bomb Enemy
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 'W'){
                    up[i][j] = 0;
                    left[i][j] = 0;
                } else {
                    up[i][j] = (grid[i][j] == 'E' ? 1:0) + (i > 0? up[i - 1][j]:0);
                    left[i][j] = (grid[i][j] == 'E' ? 1:0) + (j > 0? left[i][j - 1]:0);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (grid[i][j] == 'W'){
                    down[i][j] = 0;
                    right[i][j] = 0;
                } else {
                    down[i][j] = (grid[i][j] == 'E' ? 1:0) + (i < m - 1? down[i + 1][j]:0);
                    right[i][j] = (grid[i][j] == 'E' ? 1:0) + (j < n - 1? right[i][j + 1]:0);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '0'){
                    int tmp =up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    if (tmp > ans){
                        ans = tmp;
                    }
                }
            }
        }
        return ans;
    }
}
