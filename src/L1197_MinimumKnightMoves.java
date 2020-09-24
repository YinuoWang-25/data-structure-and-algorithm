// 1197. Minimum Knight Moves
/*
We leverage BFS because we need to find MIN step

Trick: get x, y as positive numbers. No harmful for result.
Besides all tmp x y as positive number, (-1, 2) and (2, -1) can also go back to 1st pane
So before enqueue, we check newX >= -1 && newY >= -1

 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L1197_MinimumKnightMoves {
    private final int[][] DIRECTIONS = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0], curY = cur[1];
                if (curX == x && curY == y) return result;

                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0], newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
