// 425. Word Squares

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L425_WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie(words);
        dfs(res, new ArrayList<>(), 0, words, words[0].length(), trie);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> cur, int level, String[] words, int length, Trie trie) {
        if (level == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        int size = cur.size();
        for (String s : cur) {
            prefix.append(s.charAt(size));
        }

        String pre = prefix.length() == 0 ? "" : prefix.toString();
        List<String> dictionary = trie.checkByPrefix(pre);
        for (String str : dictionary) {
            cur.add(str);
            dfs(res, cur, level + 1, words, length, trie);
            cur.remove(cur.size() - 1);
        }
    }

    class TrieNode {
        List<String> words;
        Map<Character, TrieNode> children;

        public TrieNode() {
            words = new ArrayList<>();
            children = new HashMap<>();
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
                char c = word.charAt(i);
                cur.words.add(word);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
        }

        public List<String> checkByPrefix(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!cur.children.containsKey(c)) {
                    return new ArrayList<>();
                }
                cur = cur.children.get(c);
            }
            return cur.words;
        }
    }
}
