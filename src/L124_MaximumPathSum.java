// 124. Binary Tree Maximum Path Sum

/*
    Tree return value problem. Need a helper function to recursively deal with path through every node

    update res: max(0, left) + max(0, right) + root.val
    return value: max(max(0, left) + max(0, right)) + root.val
 */

import common.TreeNode;

public class L124_MaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;

        dfs(root, res);

        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int l = Math.max(0, dfs(root.left, res));
        int r = Math.max(0, dfs(root.right, res));

        int global = l + r + root.val;
        res[0] = Math.max(global, res[0]);

        return Math.max(l, r) + root.val;
    }
}
