// 1026. Maximum Difference Between Node and Ancestor

import common.TreeNode;

public class L1026_MaximumDifference {
    int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }
        int[] lefts = dfs(root.left), rights = dfs(root.right);
        int min = root.val, max = root.val;
        if (root.left != null) {
            min = Math.min(min, lefts[0]);
            max = Math.max(max, lefts[1]);
        }
        if (root.right != null) {
            min = Math.min(min, rights[0]);
            max = Math.max(max, rights[1]);
        }
        ans = Math.max(ans, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        return new int[]{min, max};
    }
}
