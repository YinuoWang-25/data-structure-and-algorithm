// 825. Friends Of Appropriate Ages

import java.util.HashMap;
import java.util.Map;

public class L825_FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages) count.put(age, count.getOrDefault(age, 0) + 1);
        int res = 0;
        for (Integer a : count.keySet()) {
            for (Integer b : count.keySet()) {
                if (canRequest(a, b)) res += count.get(a) * (count.get(b) - (a.equals(b) ? 1 : 0));
            }
        }
        return res;
    }

    private boolean canRequest(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a);
    }
}
