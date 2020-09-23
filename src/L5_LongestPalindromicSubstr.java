// 5. Longest Palindromic Substring
public class L5_LongestPalindromicSubstr {
    private int index, maxLen;

    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        if (chs.length < 2) return s;

        for (int i = 0; i < chs.length; i++) {
            extendPalindrome(chs, i, i);
            extendPalindrome(chs, i, i + 1);
        }
        return s.substring(index, index + maxLen);
    }

    private void extendPalindrome(char[] chs, int left, int right) {
        while (left >= 0 && right < chs.length && chs[left] == chs[right]) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            index = left + 1;
            maxLen = right - left - 1;
        }
    }
}
