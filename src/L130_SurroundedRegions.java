// 130. Surrounded Regions

public class L130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'E';
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i + 1, j);
    }
}