// 28. Implement strStr()

public class L28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (i + j < haystack.length() && j < needle.length()) {
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                j++;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}
