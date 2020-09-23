// 288. Unique Word Abbreviation

import java.util.HashMap;
import java.util.Map;

public class L288_UniqueWordAbbreviation {
    Map<String, String> map;

    public L288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbv = getAbbv(word);
            if (map.containsKey(abbv) && map.get(abbv) != null && !map.get(abbv).equals(word)) {
                map.put(abbv, null);
            } else {
                map.put(abbv, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbv = getAbbv(word);
        if (!map.containsKey(abbv)) {
            return true;
        }
        return map.get(abbv) != null && map.get(abbv).equals(word);

    }

    private String getAbbv(String s) {
        if (s.length() <= 2) return s;
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}
