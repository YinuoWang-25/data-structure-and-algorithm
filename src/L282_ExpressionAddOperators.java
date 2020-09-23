// 282. Expression Add Operators

import java.util.ArrayList;
import java.util.List;

public class L282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, "", target, num, 0, 0);
        return res;
    }

    private void dfs(List<String> ans, String cur, long target, String num, long latest, int index) {
        if (index == num.length()) {
            if (target == 0) {
                ans.add(cur);
            }
            return;
        }
        for (int pos = index + 1; pos <= num.length(); pos++) {
            // corner case: leading 0
            if (num.charAt(index) == '0' && pos != index + 1) break;
            long tmp = Long.parseLong(num.substring(index, pos));
            if (index == 0) {
                dfs(ans, cur + tmp, target - tmp, num, -tmp, pos);
            } else {
                dfs(ans, cur + "+" + tmp, target - tmp, num, -tmp, pos);
                dfs(ans, cur + "-" + tmp, target + tmp, num, tmp, pos);
                dfs(ans, cur + "*" + tmp, target - latest + latest * tmp, num, tmp * latest, pos);
            }
        }

    }
}
