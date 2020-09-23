// 212. Word Search II

import java.util.*;

public class L212_WordSearchII {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(words);
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, trie.root, i, j, new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<>(res);

    }

    private void dfs(Set<String> res, char[][] board, TrieNode root, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (!root.children.containsKey(board[i][j])) {
            return;
        }
        root = root.children.get(board[i][j]);
        if (root.word != null) {
            res.add(root.word);
        }
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            dfs(res, board, root, i + dirs[k][0], j + dirs[k][1], visited);
        }
        visited[i][j] = false;

    }

    class TrieNode {
        String word = null;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    class Trie {
        TrieNode root;

        public Trie(String[] words) {
            this.root = new TrieNode();
            for (String word : words) {
                addWord(word);
            }
        }

        private void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (!cur.children.containsKey(word.charAt(i))) {
                    cur.children.put(word.charAt(i), new TrieNode());
                }
                cur = cur.children.get(word.charAt(i));
            }
            cur.word = word;
        }
    }
}
