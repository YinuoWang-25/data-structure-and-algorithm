// 1087. Brace Expansion

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1087_BraceExpansion {
    public String[] expand(String S) {
        List<String> res = new ArrayList<>();
        dfs(res, "", S, 0);
        String[] ans = res.toArray(new String[0]);
        Arrays.sort(ans);
        return ans;
    }

    private void dfs(List<String> res, String cur, String s, int index) {
        if (index == s.length()) {
            res.add(cur);
            return;
        }
        if (s.charAt(index) == '{') {
            int end = index;
            while (end < s.length() && s.charAt(end) != '}') {
                end++;
            }
            String sub = s.substring(index + 1, end);
            String[] ops = sub.split(",");
            for (String tmp : ops) {
                dfs(res, cur + tmp, s, end + 1);
            }
        } else {
            dfs(res, cur + s.charAt(index), s, index + 1);
        }
    }
}
