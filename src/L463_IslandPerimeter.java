// 463. Island Perimeter

public class L463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        // 4 * (num of 1) - num of connect
        int size = 0;
        int connect = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    size++;
                    // whether connect to top
                    if (i > 0 && grid[i - 1][j] == 1) {
                        connect++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        connect++;
                    }
                }
            }
        }
        return 4 * size - connect * 2;
    }
}
