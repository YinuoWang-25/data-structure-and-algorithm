// 863. All Nodes Distance K in Binary Tree
/**
 * 1. find all nodes on path root -> target, store all <node, dist> pair in map
 * 2. do DFS and find all nodes
 * a. we give every node a default dis with target
 * b. if this node is on the path, we update the dis
 * c. check dis to see whether it is the one we need
 */

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L863_AllNodesDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, Integer> path = new HashMap<>();
        buildPath(path, root, target);
        dfs(ans, path, root, target, path.get(root), K);
        return ans;
    }

    private void dfs(List<Integer> ans, Map<TreeNode, Integer> path, TreeNode root, TreeNode target, int length, int K) {
        if (root == null) return;
        if (path.containsKey(root)) length = path.get(root);
        if (length == K) ans.add(root.val);
        dfs(ans, path, root.left, target, length + 1, K);
        dfs(ans, path, root.right, target, length + 1, K);
    }

    private int buildPath(Map<TreeNode, Integer> path, TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            path.put(root, 0);
            return 0;
        }
        int left = buildPath(path, root.left, target);
        int right = buildPath(path, root.right, target);
        if (left >= 0) {
            path.put(root, left + 1);
            return left + 1;
        }
        if (right >= 0) {
            path.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}
