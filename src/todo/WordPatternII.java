package todo;

public class WordPatternII {
    // 291. Word Pattern II
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> dict = new HashMap<>();
        Set<String> used = new HashSet<>();
        return match(pattern, str, dict, used);
    }

    private boolean match(String pattern, String str, Map<Character, String> dict, Set<String> used) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        Character ch = pattern.charAt(0);
        if (dict.containsKey(ch)) {
            String word = dict.get(ch);
            if (!str.startsWith(word))  return false;
            return match(pattern.substring(1), str.substring(dict.get(ch).length()), dict, used);
        }
        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (used.contains(word)) continue;

            dict.put(ch, word);
            used.add(word);

            if (match(pattern.substring(1), str.substring(i + 1), dict, used))  return true;

            used.remove(word);
            dict.remove(ch);

        }
        return false;
    }
}
