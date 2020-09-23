// 222. Count Complete Tree Nodes

import common.TreeNode;

public class L222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight + 1)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getLeftHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + getLeftHeight(root.left);
    }

    private int getRightHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + getRightHeight(root.right);
    }
}
