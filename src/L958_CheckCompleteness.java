import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 958. Check Completeness of a Binary Tree
public class L958_CheckCompleteness {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> qq = new LinkedList<TreeNode>();
        qq.offer(root);
        boolean end = false;
        while (qq.size() > 0) {
            TreeNode cur = qq.poll();
            if (cur != null) {
                if (end) return false;
                qq.offer(cur.left);
                qq.offer(cur.right);
            } else end = true;
        }
        return true;
    }
}
