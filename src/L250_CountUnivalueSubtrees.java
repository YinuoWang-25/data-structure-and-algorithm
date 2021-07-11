// 250. Count Univalue Subtrees


import common.TreeNode;

public class L250_CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
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

        if ((root.left == null || (root.left.val == root.val && left == 1)) &&

                (root.right == null || (root.right.val == root.val && right == 1))
        ) {
            res[0] += 1;
            return 1;
        }
        return -1;
    }
}
