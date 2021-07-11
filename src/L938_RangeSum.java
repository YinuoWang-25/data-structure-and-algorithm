// 938. Range Sum of BST

import common.TreeNode;

public class L938_RangeSum {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        if (root.val >= L && root.val <= R) {
            res += root.val;
        }

        if (root.val > L) res += rangeSumBST(root.left, L, R);
        if (root.val < R) res += rangeSumBST(root.right, L, R);

        return res;
    }
}
