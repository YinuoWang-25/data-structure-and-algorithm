// 214. Shortest Palindrome

public class L214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();

        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(sb.substring(i))) {
                return sb.substring(0, i) + s;
            }
        }
        return "";
    }
}
