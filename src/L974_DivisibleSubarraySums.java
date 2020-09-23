// 974. Subarray Sums Divisible by K
/*

1. when sum < 0, we need to + k
 */

import java.util.HashMap;
import java.util.Map;

public class L974_DivisibleSubarraySums {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        for (int num : A) {
            sum = (sum + num) % K;
            if (sum < 0) sum += K;
            if (count.containsKey(sum)) {
                res += count.get(sum);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
