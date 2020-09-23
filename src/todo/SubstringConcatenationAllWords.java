package todo;

public class SubstringConcatenationAllWords {
    // 30. Substring with Concatenation of All Words
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0) {
            return res;
        }

        int n = s.length();
        int m = words[0].length();

        Map<String, Integer> counts = new HashMap<>();

        for (String word: words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i + words.length * m - 1 < s.length(); i++) {
            String cutStr = s.substring(i, i + words.length * m);
            if (isConcat(cutStr, counts, m)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isConcat(String s, Map<String, Integer> counts, int len) {
        Map<String, Integer> gs = new HashMap<>();
        for (int i = 0; i + len - 1 < s.length(); i += len) {
            String tmp = s.substring(i, i + len);
            gs.put(tmp, gs.getOrDefault(tmp, 0) + 1);
        }
        return gs.equals(counts);
    }
}
