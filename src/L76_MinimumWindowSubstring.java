// 76. Minimum Window Substring

public class L76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int left = 0, right = 0, start = -1, len = s.length() + 1, count = t.length();
        for (char c : t.toCharArray()) hash[c]++;
        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0) count--;
            hash[s.charAt(right)]--;
            right++;
            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) count++;
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + len);
    }
}
