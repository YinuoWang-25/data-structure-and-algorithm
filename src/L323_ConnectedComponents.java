// 323. Number of Connected Components in an Undirected Graph

import java.util.*;

public class L323_ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) continue;
            count++;
            dfs(graph, set, i);
        }
        return count;
    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> set, int i) {
        if (set.contains(i)) return;
        set.add(i);
        for (int next : graph.get(i)) {
            dfs(graph, set, next);
        }
    }
}
