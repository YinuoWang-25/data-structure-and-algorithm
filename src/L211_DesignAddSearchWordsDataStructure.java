// 211. Design Add and Search Words Data Structure

/*
    Trie problem

    Add and search can implement in recursive way or iterative way. Because of '.' here
    we implement in recursive way to make it clear
 */

import common.TrieNode;

public class L211_DesignAddSearchWordsDataStructure {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public L211_DesignAddSearchWordsDataStructure() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, 0, word);
    }

    public boolean search(TrieNode cur, int index, String word) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Character next : cur.children.keySet()) {
                if (search(cur.children.get(next), index + 1, word)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!cur.children.containsKey(word.charAt(index))) {
                return false;
            } else {
                return search(cur.children.get(word.charAt(index)), index + 1, word);
            }
        }
    }
}
