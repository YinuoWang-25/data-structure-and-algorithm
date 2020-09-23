// 269. Alien Dictionary

/*
    Topo graph problem:
        1. build the graph
            a. build nodes firstly
            b. build edges
        2. calculate and store indegree of every node
            a. build node firstly
        3. Use a queue to get all nodes with 0 indegree in batch
 */

import java.util.*;

public class L269_AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null) {
            return "";
        }
        Map<Character, Integer> indegree = getIndegree(graph);

        // as we should return the topo order with lexicographical order
        // we should use PriorityQueue instead of a FIFO Queue
        Queue<Character> queue = new PriorityQueue<>();
        for (Character u : indegree.keySet()) {
            if (indegree.get(u) == 0) {
                queue.offer(u);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character head = queue.poll();
            sb.append(head);
            for (Character neighbor : graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // may contains circle
        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }


    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        // create nodes
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }

        // create edges
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                    break;
                }
                index++;
            }

            // corner case: if no character different but length1 < length2
            if (index == Math.min(words[i].length(), words[i + 1].length())) {
                if (words[i].length() > words[i + 1].length()) {
                    return null;
                }
            }
        }

        return graph;
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character u : graph.keySet()) {
            indegree.put(u, 0);
        }

        for (Character u : graph.keySet()) {
            for (Character v : graph.get(u)) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }

        return indegree;
    }
}
