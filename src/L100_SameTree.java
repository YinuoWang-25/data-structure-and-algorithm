// 100. Same Tree

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
                queue.offer(second.left);
                queue.offer(second.right);
                queue.offer(first.right);
            }
        }
        return true;
    }
}
