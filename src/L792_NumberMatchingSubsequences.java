// 792. Number of Matching Subsequences

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L792_NumberMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new ArrayList<>());
            map.get(S.charAt(i)).add(i);
        }
        int res = 0;
        for (String word : words) {
            if (getMatch(word, map)) res++;
        }
        return res;
    }

    private boolean getMatch(String t, Map<Character, List<Integer>> map) {
        for (int i = 0, start = 0, index = -1; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) return false;
            index = getIndex(start, map.get(c));
            if (index == -1) return false;
            start = index + 1;
        }
        return true;
    }

    private int getIndex(int start, List<Integer> list) {
        if (list.get(list.size() - 1) < start) return -1;
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= start) right = mid;
            else left = mid + 1;
        }
        if (list.get(left) >= start) return list.get(left);
        return -1;
    }
}
