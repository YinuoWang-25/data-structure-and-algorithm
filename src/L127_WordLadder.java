// 127. Word Ladder

import java.util.*;

public class L127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return step + 1;
                }
                List<String> nexts = getNexts(cur, dict);
                for (String next : nexts) {
                    if (visited.add(next)) {
                        q.offer(next);
                    }
                }
            }

            step++;
        }
        return 0;
    }

    private List<String> getNexts(String origin, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < origin.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == origin.charAt(i)) continue;
                String tmp = origin.substring(0, i) + c + origin.substring(i + 1);
                if (dict.contains(tmp)) {
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
