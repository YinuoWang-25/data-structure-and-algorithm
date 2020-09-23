// 208. Implement Trie (Prefix Tree)

import java.util.HashMap;
import java.util.Map;

public class L208_ImplementTrie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public L208_ImplementTrie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                cur.children.put(word.charAt(i), new TrieNode());
            }
            cur = cur.children.get(word.charAt(i));
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                return false;
            }
            cur = cur.children.get(word.charAt(i));
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            cur = cur.children.get(prefix.charAt(i));
        }
        return true;
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }
}
