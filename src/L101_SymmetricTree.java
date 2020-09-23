// 101. Symmetric Tree

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            } else {
                queue.offer(first.left);
                queue.offer(second.right);
                queue.offer(second.left);
                queue.offer(first.right);
            }
        }
        return true;
    }
}
