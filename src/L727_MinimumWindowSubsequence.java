// 727. Minimum Window Subsequence

public class L727_MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int sindex = 0, tindex = 0, slen = s.length, tlen = t.length, start = -1, len = slen;
        while (sindex < slen) {
            if (s[sindex] == t[tindex]) {
                tindex++;
                if (tindex == tlen) {
                    tindex--;
                    //check feasibility from left to right of T
                    int end = sindex + 1;
                    //check optimization from right to left of T
                    while (tindex >= 0) {
                        if (s[sindex] == t[tindex]) tindex--;
                        sindex--;
                    }
                    sindex++;
                    tindex++;
                    //record the current smallest candidate
                    if (end - sindex < len) {
                        len = end - sindex;
                        start = sindex;
                    }
                }
            }
            sindex++;
        }
        return start == -1 ? "" : S.substring(start, start + len);
    }
}
