// 505. The Maze II

import java.util.Comparator;
import java.util.PriorityQueue;

public class L505_TheMazeII {
    class Point {
        int x, y, l;

        public Point(int _x, int _y, int _l) {
            x = _x;
            y = _y;
            l = _l;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] length = new int[m][n];
        for (int i = 0; i < m * n; i++) {
            length[i / n][i % n] = Integer.MAX_VALUE;
        }
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<Point> list = new PriorityQueue<>(Comparator.comparingInt(o -> o.l));
        list.offer(new Point(start[0], start[1], 0));
        while (!list.isEmpty()) {
            Point p = list.poll();
            if (length[p.x][p.y] <= p.l) continue;
            length[p.x][p.y] = p.l;
            for (int i = 0; i < 4; i++) {
                int xx = p.x, yy = p.y, l = p.l;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                    l++;
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                l--;
                list.offer(new Point(xx, yy, l));
            }
        }
        return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : length[destination[0]][destination[1]];
    }
}
