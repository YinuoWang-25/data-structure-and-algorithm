package todo;

public class TheMaze {
    // 490. The Maze
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {

        return dfs(maze, start[0], start[1], dest[0], dest[1], new boolean[maze.length][maze[0].length], new HashMap<String, Boolean>());
    }

    private boolean dfs(int[][] maze, int sx, int sy, int dx, int dy, boolean[][] visited, Map<String, Boolean> memo) {
        if (sx < 0 || sx >= maze.length || sy < 0 || sy >= maze[0].length || visited[sx][sy]) {
            return false;
        }
        if (sx == dx && sy == dy) {
            return true;
        }
        String curStr = sx + "-" + sy;
        if (memo.containsKey(curStr)) {
            return memo.get(curStr);
        }
        visited[sx][sy] = true;
        boolean res = false;

        for (int i = 0; i < 4; i++) {
            int x = sx;
            int y = sy;
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += directions[i][0];
                y += directions[i][1];
            }
            x -= directions[i][0];
            y -= directions[i][1];
            if (dfs(maze, x, y, dx, dy, visited, memo)) {
                res =  true;
                break;
            }
        }
        visited[sx][sy] = false;
        memo.put(curStr, res);
        return res;
    }
}
