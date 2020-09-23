// 392. Is Subsequence
public class L392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) i++;
            j++;
        }
        return i == s.length();
    }
}
