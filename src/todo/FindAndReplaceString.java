package todo;

import java.util.*;

public class FindAndReplaceString {
    // 833. Find And Replace in String

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) {
            sorted.add(new int[]{indexes[i], i});
        }
        Collections.sort(sorted, (a, b) -> (b[0] - a[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String s = sources[j], t = targets[j];
            if (S.substring(i, i + s.length()).equals(s)) {
                S = S.substring(0, i) + t + S.substring(i + s.length());
            }
        }
        return S;
    }

}
