package todo;

import java.util.*;

public class NumberMatchingSubsequences {
    // 792. Number of Matching Subsequences

    public int numMatchingSubseq(String s, String[] words) {
        int res = 0, cur, i;
        Map<Character, List<Integer>> posMap = getPositionMap(s);
        for (String w : words) {
            for (i = 0, cur = 0; i < w.length(); i++, cur++) {
                char c = w.charAt(i);
                cur = search(posMap.get(c), cur);
                if (cur == -1) break;
            }
            if (cur != -1) res++;
        }
        return res;
    }

    private Map<Character, List<Integer>> getPositionMap(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        return map;
    }

    private int search(List<Integer> pos, int start) {
        if (pos == null || pos.size() == 0) {
            return -1;
        }
        int lo = 0, hi = pos.size()-1;
        if (pos.get(lo) >= start) return pos.get(lo);
        if (pos.get(hi) < start) return -1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (pos.get(mi) == start) {
                return pos.get(mi);
            }
            if (pos.get(mi) < start) {
                lo = mi + 1;
            }
            else hi = mi - 1;
        }
        return pos.get(lo);
    }
}
