// 336. Palindrome Pairs

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L336_PalindromePairs {
    boolean isPalindrome(String str) {
        int l = str.length();
        for (int i = 0; i < l / 2; i++) {
            if (str.charAt(i) != str.charAt(l - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private int search(String s, TrieNode root) {
        for (char ch : s.toCharArray()) {
            if (root.next[ch - 'a'] != null) {
                root = root.next[ch - 'a'];
            } else {
                return -1;
            }
        }
        return root.index;
    }

    private void addWords(String[] words, TrieNode root) {
        for (int i = 0; i < words.length; i++) {
            String tmp = new StringBuilder(words[i]).reverse().toString();
            TrieNode pos = root;
            int len = tmp.length();
            for (int j = 0; j < len; j++) {
                if (pos.next[tmp.charAt(j) - 'a'] == null) {
                    TrieNode node = new TrieNode();
                    pos.next[tmp.charAt(j) - 'a'] = node;
                }
                pos = pos.next[tmp.charAt(j) - 'a'];
            }
            pos.index = i;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> ans = new LinkedList<>();
        int n = words.length;
        addWords(words, root);
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j <= len; j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j, len);
                int index = search(left, root);
                if (index != -1 && index != i && isPalindrome(right)) {
                    ans.add(Arrays.asList(i, index));
                }
                index = search(right, root);
                if (index != -1 && index != i && isPalindrome(left) && j > 0) {
                    ans.add(Arrays.asList(index, i));
                }
            }
        }
        return ans;
    }

    class TrieNode {
        public int index = -1;
        public TrieNode[] next = new TrieNode[26];
    }
}
