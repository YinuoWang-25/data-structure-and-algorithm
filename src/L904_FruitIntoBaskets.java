// 904. Fruit Into Baskets

import java.util.HashMap;
import java.util.Map;

public class L904_FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, left = 0, right = 0;
        while (right < tree.length) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            right++;
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) map.remove(tree[left]);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
