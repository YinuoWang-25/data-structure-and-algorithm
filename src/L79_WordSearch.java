// 79. Word Search

public class L79_WordSearch {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, new boolean[board.length][board[0].length], i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;
        boolean res = false;
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (dfs(board, word, index + 1, visited, x, y)) {
                res = true;
                break;
            }
        }
        visited[i][j] = false;
        return res;

    }
}
