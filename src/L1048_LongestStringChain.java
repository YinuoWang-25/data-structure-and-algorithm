// 1048. Longest String Chain
/*
For every word, we can:delete every character to make a prev.
    1. check whether prev is in map
    2. update the longest chain for word
    3. update global res
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class L1048_LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String cur = sb.deleteCharAt(i).toString();
                if (map.containsKey(cur) && map.get(cur) + 1 > map.get(word)) {
                    map.put(word, map.get(cur) + 1);
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }

}
