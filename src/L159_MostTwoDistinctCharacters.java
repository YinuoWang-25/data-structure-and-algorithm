// 159. Longest Substring with At Most Two Distinct Characters

public class L159_MostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int size = 0, left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) size++;
            while (size > 2) {
                if (count[s.charAt(left)]-- == 1) size--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
