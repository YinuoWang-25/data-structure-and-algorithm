package todo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideArrayInConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int num: nums) {
            if (counter.get(num) == 0) {
                continue;
            }
            int initial = counter.get(num);
            for (int i = num ; i < num + k; i++) {
                if (counter.getOrDefault(i, 0) < initial) {
                    return false;
                }
                counter.put(i, counter.get(i) - initial);
            }
        }
        return true;
    }
}
