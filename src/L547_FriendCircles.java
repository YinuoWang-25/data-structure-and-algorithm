// 547. Friend Circles

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L547_FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        // build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || M[i][j] == 0) continue;
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(graph, visited, i);
            }
        }
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (Integer next : graph.get(i)) {
            dfs(graph, visited, next);
        }
    }
}
