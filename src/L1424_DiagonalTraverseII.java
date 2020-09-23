// 1424. Diagonal Traverse II

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1424_DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int size = 0, maxKey = 0, index = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> cur = nums.get(i);
            for (int j = 0; j < cur.size(); j++) {
                int key = i + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(cur.get(j));
                maxKey = Math.max(maxKey, key);
                size++;
            }
        }
        int[] res = new int[size];
        for (int i = 0; i <= maxKey; i++) {
            if (map.containsKey(i)) {
                List<Integer> cur = map.get(i);
                for (Integer num : cur) {
                    res[index++] = num;
                }
            }
        }
        return res;
    }
}
