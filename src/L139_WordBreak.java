// 139. Word Break

import java.util.*;

public class L139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict, new HashMap<>());
    }

    private boolean dfs(String s, Set<String> dict, Map<String, Boolean> memo) {
        if (s.length() == 0) return true;
        if (memo.containsKey(s)) return memo.get(s);
        boolean res = false;
        for (int j = 1; j <= s.length(); j++) {
            String tmp = s.substring(0, j);
            if (dict.contains(tmp)) {
                res |= dfs(s.substring(j), dict, memo);
            }
        }
        memo.put(s, res);
        return res;
    }
}
