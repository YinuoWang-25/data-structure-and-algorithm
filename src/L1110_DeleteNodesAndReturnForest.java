import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1110_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();

        Set<Integer> toDelete = new HashSet<>();
        for (int node : to_delete) {
            toDelete.add(node);
        }

        TreeNode newRoot = dfs(res, toDelete, root);

        if (newRoot != null) {
            res.add(newRoot);
        }
        return res;
    }

    private TreeNode dfs(List<TreeNode> res, Set<Integer> toDelete, TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = dfs(res, toDelete, node.left);
        TreeNode right = dfs(res, toDelete, node.right);

        if (toDelete.contains(node.val)) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        } else {
            node.left = left;
            node.right = right;
            return node;
        }
    }
}
