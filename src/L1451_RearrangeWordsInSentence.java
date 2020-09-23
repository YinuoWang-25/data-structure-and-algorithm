// 1451. Rearrange Words in a Sentence

import java.util.*;

public class L1451_RearrangeWordsInSentence {
    public String arrangeWords(String text) {
        if (text == null || text.length() == 0) return text;
        String[] strs = text.split(" ");
        if (strs.length == 1) {
            return strs[0];
        }
        strs[0] = strs[0].substring(0, 1).toLowerCase() + strs[0].substring(1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<>());
            }
            map.get(len).add(i);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder res = new StringBuilder();
        for (Integer key : keys) {
            List<Integer> a = map.get(key);
            for (Integer integer : a) {
                res.append(strs[integer]).append(" ");
            }
        }
        return res.substring(0, 1).toUpperCase() + res.substring(1, res.length() - 1);

    }
}
