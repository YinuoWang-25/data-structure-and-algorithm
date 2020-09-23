// 140. Word Break II

import java.util.*;

public class L140_WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, dict, memo);
    }

    public List<String> dfs(String s,
                            Set<String> dict,
                            Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> results = new ArrayList<>();

        if (s.length() == 0) return results;

        if (dict.contains(s)) results.add(s);

        for (int len = 1; len < s.length(); ++len) {
            String word = s.substring(0, len);
            if (!dict.contains(word)) continue;

            String suffix = s.substring(len);
            List<String> segmentations = dfs(suffix, dict, memo);

            for (String segmentation : segmentations) {
                results.add(word + " " + segmentation);
            }
        }
        memo.put(s, results);
        return results;
    }
}
