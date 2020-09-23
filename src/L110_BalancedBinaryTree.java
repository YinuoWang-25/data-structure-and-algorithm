// 110. Balanced Binary Tree

import common.TreeNode;

public class L110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if (Math.abs(lh - rh) > 1) {
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    int getHeight(TreeNode node) {
        if (node == null) return 0;
        int lh = getHeight(node.left);
        int rh = getHeight(node.right);
        return Math.max(lh, rh) + 1;
    }

}
