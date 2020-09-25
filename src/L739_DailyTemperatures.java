// 739. Daily Temperatures

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class L739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]) {
                map.put(stack.pollFirst(), i);
            }
            stack.offerFirst(i);
        }
        for (int i = 0; i < T.length; i++) {
            if (map.containsKey(i)) T[i] = map.get(i) - i;
            else T[i] = 0;
        }
        return T;
    }
}
