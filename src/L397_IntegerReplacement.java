// 397. Integer Replacement


import java.util.HashMap;
import java.util.Map;

public class L397_IntegerReplacement {
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 0);

        return helper(n, map);
    }

    private int helper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int steps = -1;
        if (n % 2 == 0) {
            steps = helper(n / 2, map) + 1;
        } else {
            steps = Math.min(helper((n - 1), map) + 1, helper(1 + (n - 1) / 2, map) + 2);
        }

        map.put(n, steps);

        return steps;
    }
}
