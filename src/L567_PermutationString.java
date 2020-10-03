// 567. Permutation in String

public class L567_PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] hash = new char[26];
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }
        int count = s1.length(), left = 0, right = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            if (hash[r - 'a'] > 0) count--;
            hash[r - 'a']--;
            right++;
            if (right - left > s1.length()) {
                char l = s2.charAt(left);
                hash[l - 'a']++;
                if (hash[l - 'a'] > 0) count++;
                left++;
            }
            if (count == 0) return true;
        }
        return false;
    }
}
