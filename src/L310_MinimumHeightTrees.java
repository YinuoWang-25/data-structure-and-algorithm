// 310. Minimum Height Trees

import java.util.*;

public class L310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree.put(edge[0], indegree.get(edge[0]) + 1);
            indegree.put(edge[1], indegree.get(edge[1]) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                res.add(cur);
                for (int next : graph.get(cur)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 1) {
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }
}
