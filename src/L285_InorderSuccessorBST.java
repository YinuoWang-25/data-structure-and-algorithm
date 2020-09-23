// 285. Inorder Successor in BST

import common.TreeNode;

public class L285_InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode left = inorderSuccessor(root.left, p);
        if (left == null) return root;
        return left;
    }
}
