// 114. Flatten Binary Tree to Linked List

import common.TreeNode;

public class L114_FlattenBinaryTreeLinkedList {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        TreeNode rightMost = root.left;
        if (rightMost == null) {
            root.right = dfs(root.right);
        } else {
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = right;
            root.right = dfs(root.left);
            root.left = null;
        }
        return root;

    }
}
