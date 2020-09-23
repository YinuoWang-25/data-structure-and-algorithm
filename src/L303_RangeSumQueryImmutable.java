// 303. Range Sum Query - Immutable

import java.util.HashMap;
import java.util.Map;

public class L303_RangeSumQueryImmutable {
    Map<Integer, Integer> map;

    public L303_RangeSumQueryImmutable(int[] nums) {
        map = new HashMap<>();
        map.put(-1, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        return map.get(j) - map.get(i - 1);

    }
}
