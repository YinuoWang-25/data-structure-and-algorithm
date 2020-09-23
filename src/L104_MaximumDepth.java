// 104. Maximum Depth of Binary Tree

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L104_MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return level;
    }
}
