// 305. Number of Islands II

import java.util.ArrayList;
import java.util.List;

public class L305_NumberIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m, n);
        List<Integer> res = new ArrayList<>();
        for (int[] pos : positions) {
            res.add(uf.add(pos[0], pos[1]));
        }
        return res;
    }
}

class UnionFind {
    int num;
    int m;
    int n;
    int[] fathers;
    int[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public UnionFind(int m, int n) {
        this.num = 0;
        this.m = m;
        this.n = n;
        this.fathers = new int[m * n];
        this.grid = new int[m][n];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public int add(int x, int y) {
        if (grid[x][y] == 1) return num;
        num++;
        grid[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dirs[i][0];
            int b = y + dirs[i][1];
            if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] == 1) {
                union(x * n + y, a * n + b);
            }
        }
        return num;
    }

    private int find(int x) {
        if (fathers[x] != x) {
            fathers[x] = find(fathers[x]);
        }
        return fathers[x];
    }

    private void union(int a, int b) {
        int fatherA = find(a);
        int fatherB = find(b);
        if (fatherA != fatherB) {
            fathers[fatherA] = fatherB;
            num--;
        }
    }
}
