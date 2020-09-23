// 404. Sum of Left Leaves

import common.TreeNode;

public class L404_SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        dfs(root, sum, false);
        return sum[0];
    }

    private void dfs(TreeNode root, int[] sum, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            sum[0] += root.val;
        }
        dfs(root.left, sum, true);
        dfs(root.right, sum, false);
    }
}
