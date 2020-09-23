// 833. Find And Replace in String

/*
1. build a map to record all start point need to be replaced

2. Scan String S from left to right.
 case 1: no need to replace, we can just append the char
 case 1: need to replace. We can append target[i] and update index
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L833_FindAndReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) table.put(indexes[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); ) {
            if (table.containsKey(i)) {
                sb.append(targets[table.get(i)]);
                i += sources[table.get(i)].length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }


    /**
     * Straightforward but slow
     */
    public String findReplaceStringII(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            sorted.add(new int[]{indexes[i], i});
        }
        sorted.sort((a, b) -> (b[0] - a[0]));

        for (int[] index : sorted) {
            String source = sources[index[1]], target = targets[index[1]];
            if (S.startsWith(source, index[0])) {
                S = S.substring(0, index[0]) + target + S.substring(index[0] + source.length());
            }
        }
        return S;
    }

}
