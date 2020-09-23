// 270. Closest Binary Search Tree Value

import common.TreeNode;

public class L270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        while (root != null) {
            ans = Math.abs(root.val - target) < Math.abs(ans - target) ? root.val : ans;
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }
}
