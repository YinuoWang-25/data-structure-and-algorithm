// 1325. Delete Leaves With a Given Value

import common.TreeNode;

public class L1325_DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if (left == null && right == null && root.val == target) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
