// 347. Top K Frequent Elements

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Integer key : map.keySet()) {
            buckets[map.get(key)].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0 && k > 0; i--) {
            for (int j = 0; j < buckets[i].size(); j++) {
                if (k == 0) break;
                res[index++] = buckets[i].get(j);
                k--;
            }
        }
        return res;
    }
}
