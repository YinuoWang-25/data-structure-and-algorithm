// 1583. Count Unhappy Friends

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1583_CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        if (pairs.length == 0) return 0;
        Set<Integer> happy = new HashSet<>();
        Set<Integer> unhappy = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : pairs) {
            map.put(p[0], p[1]);
            map.put(p[1], p[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i) || happy.contains(i) || unhappy.contains(i)) continue;
            int j = map.get(i);
            int[] px = preferences[i];
            int m = 0;
            while (px[m] != j) {
                int u = px[m];
                int v = map.get(u);
                int[] pu = preferences[u];
                int k = 0;
                while (pu[k] != v) {
                    if (pu[k] == i) {
                        unhappy.add(i);
                        unhappy.add(u);
                        break;
                    }
                    k++;
                }
                if (unhappy.contains(i)) {
                    break;
                }
                m++;
            }
        }
        return unhappy.size();
    }
}
