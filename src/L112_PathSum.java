// 112. Path Sum

import common.TreeNode;

public class L112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return sum == 0;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
