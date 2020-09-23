package todo;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 0});
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();
                if (cur[0] == m -1 && cur[1] == n - 1) return res;
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dirs[i][0];
                    int y = cur[1] + dirs[i][1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int nextK = cur[2];
                    if (nextK + grid[x][y] <= k && !visited[x][y][nextK + grid[x][y]]) {
                        q.offer(new int[]{x, y, nextK + grid[x][y]}) ;
                        visited[x][y][nextK + grid[x][y]] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
