// 226. Invert Binary Trees

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = right;
            cur.right = left;
            if (left != null) q.offer(left);
            if (right != null) q.offer(right);
        }
        return root;
    }
}
