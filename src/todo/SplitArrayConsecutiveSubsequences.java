package todo;

import java.util.*;

public class SplitArrayConsecutiveSubsequences {
    // 659. Split Array into Consecutive Subsequences

    public boolean isPossible(int[] nums) {
        /*
            for every num, we can:
            1. append it on an existing list  // prefered
                when: there is an existing one with last number as num - 1
            2. start a new list
                when: we can find a num + 1 and num + 2

        */
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.putIfAbsent(num, 0);
            counts.put(num, counts.get(num) + 1);
        }
        Map<Integer, Integer> lists = new HashMap<>();
        for (int num : nums) {
            if (counts.get(num) == 0) continue;
            if (lists.getOrDefault(num - 1, 0) > 0) {
                lists.put(num, lists.getOrDefault(num, 0) + 1);
                lists.put(num - 1, lists.get(num - 1) - 1);
            } else {
                if (
                        counts.getOrDefault(num + 1, 0) > 0 &&
                                counts.getOrDefault(num + 2, 0) > 0
                ) {
                    counts.put(num + 1, counts.get(num + 1) - 1);
                    counts.put(num + 2, counts.get(num + 2) - 1);
                    lists.put(num + 2, lists.getOrDefault(num + 2, 0) + 1);
                } else {
                    return false;
                }

            }
            counts.put(num, counts.get(num) - 1);
        }
        return true;


    }
}
