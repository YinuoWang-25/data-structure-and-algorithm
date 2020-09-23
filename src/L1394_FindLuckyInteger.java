// 1394. Find Lucky Integer in an Array

import java.util.HashMap;
import java.util.Map;

public class L1394_FindLuckyInteger {
    public int findLucky(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int value : arr) {
            count.put(value, count.getOrDefault(value, 0) + 1);
        }
        Integer ans = null;
        for (Integer key : count.keySet()) {
            if (key.equals(count.get(key))) {
                if (ans == null || key > ans) ans = key;
            }
        }
        return ans == null ? -1 : ans;

    }
}
