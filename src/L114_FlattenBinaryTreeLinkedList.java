// 114. Flatten Binary Tree to Linked List

import common.TreeNode;

public class L114_FlattenBinaryTreeLinkedList {
    public void flatten(TreeNode root) {
        traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode l = traverse(root.left);
        TreeNode r = traverse(root.right);

        root.left = null;

        if (l == null) {
            root.right = r;
        } else {
            root.right = l;
            while (l.right != null) {
                l = l.right;
            }
            l.right = r;
        }

        return root;
    }
}
