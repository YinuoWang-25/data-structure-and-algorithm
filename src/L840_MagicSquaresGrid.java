// 840. Magic Squares In Grid
/*
For every 3 * 3 square, check whether it is magic square
    1. check whether center number is 5
    2. check whether has all 1 - 9
 */

public class L840_MagicSquaresGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i <= grid.length - 3; i++)
            for (int j = 0; j <= grid[0].length - 3; j++)
                if (helper(i, j, grid)) cnt++;

        return cnt;
    }

    private boolean helper(int x, int y, int[][] grid) {
        // check whether center number is 5
        if (grid[x + 1][y + 1] != 5) return false;

        // check whether has all 1 - 9
        int[] seen = new int[16];
        for (int i = x; i <= x + 2; i++)
            for (int j = y; j <= y + 2; j++)
                seen[grid[i][j]]++;

        for (int v = 1; v <= 9; v++)
            if (seen[v] != 1) return false;

        if ((grid[x][y] + grid[x][y + 1] + grid[x][y + 2]) != 15) return false;
        if ((grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2]) != 15) return false;
        if ((grid[x][y] + grid[x + 1][y] + grid[x + 2][y]) != 15) return false;
        if ((grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2]) != 15) return false;
        if ((grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2]) != 15) return false;
        return (grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y]) == 15;
    }
}
