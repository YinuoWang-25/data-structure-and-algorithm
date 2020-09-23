// 3. Longest Substring Without Repeating Characters

import java.util.HashMap;
import java.util.Map;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> hash = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); ++right) {
            if (hash.containsKey(s.charAt(right))) {
                left = Math.max(left, hash.get(s.charAt(right)) + 1);
            }
            hash.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
