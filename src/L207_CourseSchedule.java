// 207. Course Schedule

import java.util.*;

public class L207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> counters = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
            counters.put(i, 0);
        }
        for (int[] edge : prerequisites) {
            map.get(edge[1]).add(edge[0]);
            counters.put(edge[0], counters.get(edge[0]) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer edge : counters.keySet()) {
            if (counters.get(edge) == 0) {
                queue.add(edge);
            }
        }
        int num = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            num++;
            for (Integer next : map.get(cur)) {
                counters.put(next, counters.get(next) - 1);
                if (counters.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return num == numCourses;
    }
}
