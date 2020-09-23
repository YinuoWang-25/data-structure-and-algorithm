// 301. Remove Invalid Parentheses

/*
    Two way check:
        1. from left to right and delete invalid close parentheses
        2. from right to left and delete invalid open parentheses
 */

import java.util.ArrayList;
import java.util.List;

public class L301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void dfs(List<String> res, String s, int last_index, int last_delete, char[] pair) {
        int count = 0;
        for (int i = last_index; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = last_delete; j <= i; j++) {
                if (s.charAt(j) != pair[1]) continue;
                if (j != last_delete && s.charAt(j - 1) == s.charAt(j)) continue;
                dfs(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(')
            dfs(res, reversed, 0, 0, new char[]{')', '('});
        else
            res.add(reversed);
    }
}
