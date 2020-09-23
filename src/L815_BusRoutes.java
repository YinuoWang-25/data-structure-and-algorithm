// 815. Bus Routes

import java.util.*;

public class L815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        for (int k = 0; k < routes.length; k++) {
            for (int i = 0; i < routes[k].length; i++) {
                stopToBus.putIfAbsent(routes[k][i], new ArrayList<>());
                stopToBus.get(routes[k][i]).add(k);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int step = 1;
        q.offer(S);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<Integer> buses = stopToBus.get(q.poll());
                for (int bus : buses) {
                    if (!visited.add(bus)) continue;
                    for (int next : routes[bus]) {
                        if (next == T) return step;
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
