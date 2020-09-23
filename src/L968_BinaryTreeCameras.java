// 968. Binary Tree Cameras

/*

Intuition: For parent of leaves node, we must put one. We can think about this problem in this way recursively

Return 0 if node is a leaf.
Return 1 if it's a parent of a leaf, with a camera on this node.
Return 2 if it's covered, without a camera on this node.

 */

import common.TreeNode;

public class L968_BinaryTreeCameras {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
