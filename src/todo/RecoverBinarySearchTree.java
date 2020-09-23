package todo;

public class RecoverBinarySearchTree {
    // 99. Recover Binary Search Tree
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && root.val < prev.val) {
            first = prev;
        }
        if (first != null && root.val < prev.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
