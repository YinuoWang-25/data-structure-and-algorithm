// 803. Bricks Falling When Hit

import java.util.Arrays;

public class L803_BricksFallingWhenHit {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = 2;
        }

        UnionFind uf = new UnionFind(m * n + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionCell(uf, grid, i, j);
                }
            }
        }

        int brickLeft = uf.size[uf.find(0)];
        int[] ans = new int[hits.length];

        for (int j = hits.length - 1; j >= 0; j--) {
            if (grid[hits[j][0]][hits[j][1]] != 2) continue;
            grid[hits[j][0]][hits[j][1]] = 1;
            unionCell(uf, grid, hits[j][0], hits[j][1]);
            int curBricks = uf.size[uf.find(0)];
            int diff = curBricks - brickLeft - 1;
            brickLeft = curBricks;
            ans[j] = Math.max(diff, 0);
        }

        return ans;
    }

    private void unionCell(UnionFind uf, int[][] grid, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
            uf.union(i * grid[0].length + j + 1, x * grid[0].length + y + 1);
        }
        if (i == 0) uf.union(0, i * grid[0].length + j + 1);
    }


    class UnionFind {
        int[] parents;
        int[] size;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (parents[x] == x) return x;
            parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                parents[fx] = fy;
                size[fy] += size[fx];
            }
        }
    }

}
