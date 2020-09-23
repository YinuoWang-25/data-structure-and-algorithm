// 1056. Confusing Number

import java.util.HashMap;
import java.util.Map;

public class L1056_ConfusingNumber {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int m = N, after = 0;
        while (N > 0) {
            int cur = N % 10;
            if (!map.containsKey(cur)) return false;
            N /= 10;
            after = after * 10 + map.get(cur);
        }

        return after != m;
    }
}
