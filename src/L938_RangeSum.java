// 938. Range Sum of BST

import common.TreeNode;

public class L938_RangeSum {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] sum = new int[1];
        getSum(root, L, R, sum);
        return sum[0];
    }

    private void getSum(TreeNode root, int L, int R, int[] sum) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) sum[0] += root.val;
        if (root.val > L) getSum(root.left, L, R, sum);
        if (root.val < R) getSum(root.right, L, R, sum);
    }
}
