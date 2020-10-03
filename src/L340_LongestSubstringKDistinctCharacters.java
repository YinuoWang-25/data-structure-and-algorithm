// 340. Longest Substring with At Most K Distinct Characters
/*
    Sliding window:
        expand: one more character on right side
        shrink left side until can get result
        check whether is ans and add it
 */

public class L340_LongestSubstringKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int size = 0, left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) size++;
            while (size > k) {
                if (count[s.charAt(left)]-- == 1) size--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
