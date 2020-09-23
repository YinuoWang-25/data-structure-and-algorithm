// 1448. Count Good Nodes in Binary Tree

import common.TreeNode;

public class L1448_CountGoodNodes {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, Integer.MIN_VALUE, res);
        return res[0];
    }

    private void dfs(TreeNode root, int preMax, int[] res) {
        if (root == null) return;
        if (root.val >= preMax) res[0]++;
        int curMax = Math.max(preMax, root.val);
        dfs(root.left, curMax, res);
        dfs(root.right, curMax, res);
    }
}
