// 199. Binary Tree Right Side View

/*
    DFS traverse the tree. For every node, we always visit right child firstly,
     which can make sure for each level, we can reach the rightmost node first.
 */

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 1);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level > res.size()) {
            res.add(root.val);
        }
        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
    }
}
