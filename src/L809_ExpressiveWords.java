// 809. Expressive Words
/*
    Scan string and find group. For each group, we need to do check in three cases:
        1. characters are not the same
        2. len(ss) >= 3 then check len(ss) > len(tt)
        3. len(ss) < 3 then check len(ss) == len(tt)
 */

public class L809_ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            res += isExpressive(S, word) ? 1 : 0;
        }
        return res;
    }

    private boolean isExpressive(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {

            // case 1: diff character
            if (s.charAt(i) != t.charAt(j)) return false;
            int ri = i;
            while (ri < s.length() && s.charAt(ri) == s.charAt(i)) {
                ri++;
            }
            int rj = j;
            while (rj < t.length() && t.charAt(rj) == t.charAt(j)) {
                rj++;
            }
            // case 2: len(ss) >= 3 then check len(ss) > len(tt)
            if (ri - i >= 3 && ri - i < rj - j) return false;

                // case 3: len(ss) < 3 then check len(ss) == len(tt)
            else if (ri - i < 3 && ri - i != rj - j) return false;
            i = ri;
            j = rj;
        }
        return i == s.length() && j == t.length();
    }
}
