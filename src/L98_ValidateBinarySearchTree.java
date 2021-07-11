// 98. Validate Binary Search Tree

import common.TreeNode;

public class L98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return true;
        }

        if (left != null && left.val >= root.val) return false;

        if (right != null && right.val <= root.val) return false;

        return isValid(root.left, left, root) && isValid(root.right, root, right);

    }
}
