// 444. Sequence Reconstruction

import java.util.*;

public class L444_SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
                indegree.putIfAbsent(seq.get(i), 0);
                if (i > 0) {
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        if (org.length != indegree.size()) return false;
        Queue<Integer> q = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.offer(key);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) return false;
            int cur = q.poll();
            if (cur != org[index++]) return false;
            for (Integer next : graph.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.offer(next);
            }
        }
        return index == org.length;
    }
}
