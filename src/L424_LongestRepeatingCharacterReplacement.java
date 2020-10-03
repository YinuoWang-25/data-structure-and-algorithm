// 424. Longest Repeating Character Replacement

public class L424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxCount = 0, start = 0, maxSize = 0;

        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(end) - 'A']);

            if (end - start + 1 - maxCount > k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }
            maxSize = Math.max(maxSize, end - start + 1);
        }
        return maxSize;
    }
}
