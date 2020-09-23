import java.util.HashMap;
import java.util.Map;
// 128. Longest Consecutive Sequence

public class L128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int sum = left + right + 1;
                map.put(n, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
