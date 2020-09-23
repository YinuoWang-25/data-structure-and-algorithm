// 340. Longest Substring with At Most K Distinct Characters
/*
    Sliding window:
        expand: one more character on right side
        shrink left side until can get result
        check whether is ans and add it
 */

import java.util.HashMap;
import java.util.Map;

public class L340_LongestSubstringKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < s.length()) {
            char r = s.charAt(right++);
            hash.put(r, hash.getOrDefault(r, 0) + 1);
            while (left < right && hash.size() > k) {
                char l = s.charAt(left);
                hash.put(l, hash.get(l) - 1);
                if (hash.get(l) == 0) {
                    hash.remove(l);
                }
                left++;
            }
            if (hash.size() <= k) {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}
