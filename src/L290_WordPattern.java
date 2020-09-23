// 290. Word Pattern

import java.util.HashMap;
import java.util.Map;

public class L290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character, String> hash = new HashMap<>();
        if (strs.length != pattern.length()) return false;
        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            if (hash.containsKey(c)) {
                if (!hash.get(c).equals(strs[i])) return false;
            } else {
                if (hash.containsValue(strs[i])) return false;
                hash.put(c, strs[i]);
            }
        }
        return true;
    }
}
