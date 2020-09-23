// 320. Generalized Abbreviation

/*
For every level, we have two options:
1. we can skip this character and put it in abbreviation
2. we print numbers as skipped characters, and print this character
 */

import java.util.ArrayList;
import java.util.List;

public class L320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        String cur = "";
        dfs(res, word, 0, cur, 0);
        return res;
    }

    private void dfs(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                cur += count;
            }
            res.add(cur);
        } else {
            dfs(res, word, pos + 1, cur, count + 1);
            if (count > 0) {
                cur = cur + count + word.charAt(pos);
            } else {
                cur = cur + word.charAt(pos);
            }
            dfs(res, word, pos + 1, cur, 0);
        }
    }
}
