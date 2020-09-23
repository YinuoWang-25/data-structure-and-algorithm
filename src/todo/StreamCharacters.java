package todo;

import java.util.*;

public class StreamCharacters {
    // 1032. Stream of Characters
    class TrieNode {
        String word;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.word = "";
            this.children = new HashMap<>();
        }
    }
    TrieNode root;
    List<Character> chs;
    public StreamCharacters(String[] words) {
        root = new TrieNode();
        chs = new ArrayList<>();
        for (String word : words) {
            add(word);
        }
    }

    private void add(String word) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }

    public boolean query(char letter) {
        chs.add(letter);
        TrieNode cur = root;
        for (int i = chs.size() - 1; i >= 0; i--) {
            char c = chs.get(i);
            if (!cur.children.containsKey(c)) {
                return false;
            }
            if (cur.children.get(c).word.length() > 0) {
                return true;
            }
            cur = cur.children.get(c);
        }
        return false;
    }
}
