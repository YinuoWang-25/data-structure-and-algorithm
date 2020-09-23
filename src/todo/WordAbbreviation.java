package todo;
// 527. Word Abbreviation

import java.util.*;

public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        String[] ans = new String[dict.size()];
        Map<String, Integer> count = new HashMap<>();
        int round = 1;

        for (int i = 0; i < dict.size(); i++) {
            ans[i] = getAbbr(dict.get(i), round);
            count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
        }

        while (true) {
            boolean unique = true;
            round++;
            for (int i = 0; i < dict.size(); i++) {
                if (count.get(ans[i]) > 1) {
                    ans[i] = getAbbr(dict.get(i), round);
                    count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
                    unique = false;
                }
            }
            if (unique) {
                break;
            }
        }
        List<String> res = new ArrayList<>();
        Collections.addAll(res, ans);
        return res;
    }

    private String getAbbr(String s, int p) {
        if (p + 2 >= s.length()) {
            return s;
        }
        String ans;
        ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
        return ans;
    }
}
