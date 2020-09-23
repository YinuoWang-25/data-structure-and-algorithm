// 827. Making A Large Island

/**
 * 1. DFS to find all island. For each island, we color it as index, and store the <index, size> pair into a map
 * 2. for every non-island cell, try to see what is the largest island size when turn it from 0 -> 1
 * calculate sum of size for four adjacent cell
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L827_MakingALargeIsland {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> sizes = new HashMap<>();
        int max = 0, index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, index++);
                    max = Math.max(max, size);
                    sizes.put(index - 1, size);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) continue;
                int size = 1;
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || set.contains(grid[x][y])) {
                        continue;
                    }
                    set.add(grid[x][y]);
                    size += sizes.get(grid[x][y]);
                }
                max = Math.max(max, size);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int index) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int res = 1;
        for (int k = 0; k < 4; k++) {
            res += dfs(grid, i + dirs[k][0], j + dirs[k][1], index);
        }
        return res;
    }
}
