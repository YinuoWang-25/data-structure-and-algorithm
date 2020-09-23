// 737. Sentence Similarity II

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L737_SentenceSimilarityIl {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, String> roots = new HashMap<>();

        for (List<String> pair : pairs) {
            String r1 = find(roots, pair.get(0));
            String r2 = find(roots, pair.get(1));
            if (!r1.equals(r2)) roots.put(r1, r2);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!find(roots, words1[i]).equals(find(roots, words2[i]))) return false;
        }
        return true;
    }

    private String find(Map<String, String> roots, String cur) {
        if (!roots.containsKey(cur) || roots.get(cur).equals(cur)) return cur;
        String father = find(roots, roots.get(cur));
        roots.put(cur, father);
        return father;
    }
}
