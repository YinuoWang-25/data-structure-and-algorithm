// 802. Find Eventual Safe States

import java.util.*;

public class L802_FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> reverse = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            degree.put(i, 0);
            reverse.put(i, new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                degree.put(i, degree.get(i) + 1);
                reverse.get(graph[i][j]).add(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < degree.size(); i++) {
            if (degree.get(i) > 0) continue;
            queue.add(i);
            set.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (Integer next : reverse.get(cur)) {
                if (set.contains(next)) continue;
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) {
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
