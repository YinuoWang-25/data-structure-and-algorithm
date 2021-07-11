// 270. Closest Binary Search Tree Value

import common.TreeNode;

public class L270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }

        if (root.val < target) {
            int r = closestValue(root.right, target);
            return Math.abs(r - target) < Math.abs(root.val - target) ? r : root.val;
        } else if (root.val > target) {
            int l = closestValue(root.left, target);
            return Math.abs(l - target) < Math.abs(root.val - target) ? l : root.val;
        }

        return root.val;
    }
}
