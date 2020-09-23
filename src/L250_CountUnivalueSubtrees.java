// 250. Count Univalue Subtrees


import common.TreeNode;

public class L250_CountUnivalueSubtrees {
    int ans = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.left);
        if ((root.left == null || (root.left.val == root.val && left == 1)) &&

                (root.right == null || (root.right.val == root.val && left == 1))
        ) {
            ans += 1;
            return 1;
        }
        return -1;
    }
}
