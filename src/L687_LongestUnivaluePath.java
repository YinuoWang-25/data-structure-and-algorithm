// 687. Longest Univalue Path

import common.TreeNode;

public class L687_LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        dfs(res, root);

        return res[0];
    }

    private int dfs(int[] res, TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(res, root.left);
        int right = dfs(res, root.right);

        int cur = 1, l = 0, r = 0;

        if (root.left != null && root.left.val == root.val) {
            l = left;
        }

        if (root.right != null && root.right.val == root.val) {
            r = right;
        }

        res[0] = Math.max(res[0], cur + l + r);

        return cur + Math.max(l, r);
    }
}
