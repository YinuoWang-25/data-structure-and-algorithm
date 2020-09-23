// 159. Longest Substring with At Most Two Distinct Characters

import java.util.HashMap;
import java.util.Map;

public class L159_MostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int len = 0, left = 0, right = 0;
        while (right < s.length()) {
            char last = s.charAt(right);
            map.put(last, map.getOrDefault(last, 0) + 1);
            right++;
            while (map.size() > 2) {
                char first = s.charAt(left);
                map.put(first, map.get(first) - 1);
                if (map.get(first) == 0) {
                    map.remove(first);
                }
                left++;
            }
            len = Math.max(right - left, len);
        }
        return len;
    }
}
