// 133. Clone Graph

/*
    DFS to clone
 */

import common.GraphNode;

import java.util.HashMap;
import java.util.Map;

public class L133_CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        Map<GraphNode, GraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, new GraphNode(node.val));
        for (GraphNode neighbor : node.neighbors) {
            map.get(node).neighbors.add(dfs(neighbor, map));
        }
        return map.get(node);
    }
}
