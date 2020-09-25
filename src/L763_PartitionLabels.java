// 763. Partition Labels
/*
1. We need to keep the last index of every character
2. scan the array from left to right, for every char, we mark the last index we
need to do until now. if max index == current index. It means that we can partition here
 */

import java.util.ArrayList;
import java.util.List;

public class L763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++) map[S.charAt(i) - 'a'] = i;
        // record the end index of the current sub string
        int last = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
