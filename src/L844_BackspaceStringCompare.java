// 844. Backspace String Compare

/**
 *
 */

public class L844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            int pound = 0;
            while (i >= 0 && (pound > 0 || S.charAt(i) == '#')) {
                pound += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            pound = 0;
            while (j >= 0 && (pound > 0 || T.charAt(j) == '#')) {
                pound += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else break;
        }
        return i == -1 && j == -1;
    }
}
