package todo;

public class Minesweeper {
    // 529. Minesweeper
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int count = count(board, x, y);
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (count > 0) {
            board[x][y] = (char) ('0' + count);
        } else {
            board[x][y] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    if (i + x < 0 || i + x >= board.length || j + y < 0 || j + y >= board[0].length) continue;
                    if (board[i + x][j + y] == 'E') {
                        dfs(board, i + x, j + y);
                    }
                }
            }
        }

    }

    private int count(char[][] board, int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (i + x < 0 || i + x >= board.length || j + y < 0 || j + y >= board[0].length) continue;
                if (board[i + x][j + y] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
