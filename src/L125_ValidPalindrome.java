// 125. Valid Palindrome

public class L125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chs[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chs[right])) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(chs[left]) == Character.toLowerCase(chs[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
