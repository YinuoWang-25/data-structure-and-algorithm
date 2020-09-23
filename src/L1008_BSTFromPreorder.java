import common.TreeNode;
// 1008. Construct Binary Search Tree from Preorder Traversal

public class L1008_BSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return part(preorder, 0, preorder.length - 1);
    }

    private TreeNode part(int[] preorder, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[left]);
        int small = left + 1;
        while (small <= right && preorder[small] < preorder[left]) {
            small++;
        }
        root.left = part(preorder, left + 1, small - 1);
        root.right = part(preorder, small, right);
        return root;
    }
}
