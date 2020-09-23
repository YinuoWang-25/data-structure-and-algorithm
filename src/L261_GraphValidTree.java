// 261. Graph Valid Tree

import java.util.*;

public class L261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        set.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!map.containsKey(cur)) {
                continue;
            }
            for (int next : map.get(cur)) {
                if (set.add(next)) {
                    q.offer(next);
                }
            }
        }
        return set.size() == n;
    }
}
