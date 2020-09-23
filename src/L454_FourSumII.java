// 454. 4Sum II

import java.util.HashMap;
import java.util.Map;

public class L454_FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : C) {
            for (int i : D) {
                int sum = value + i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int value : A) {
            for (int i : B) {
                res += map.getOrDefault(-1 * (value + i), 0);
            }
        }

        return res;
    }

}
