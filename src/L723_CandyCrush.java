// 723. Candy Crush
/*
    Intuition: simulate the process until we reach the final stable state

    1. mark the cell we can crush

    2. for every column, check from bottom to top, fill out the ones that are not crushed
 */
public class L723_CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean isStable = false;
        while (!isStable) {
            isStable = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue; // empty cell
                    if (j < n - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        isStable = false;
                        for (int k = j; k <= j + 2; k++) board[i][k] = -val;
                    }
                    if (i < m - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        isStable = false;
                        for (int k = i; k <= i + 2; k++) board[k][j] = -val;
                    }
                }
            }
            if (!isStable) {
                for (int j = 0; j < n; j++) {
                    int temp = m - 1;
                    for (int i = m - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[temp--][j] = board[i][j];
                        }
                    }
                    for (int i = temp; i >= 0; i--) board[i][j] = 0;
                }
            }
        }
        return board;
    }
}
