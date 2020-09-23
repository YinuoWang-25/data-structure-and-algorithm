// 102. Binary Tree Level Order Traversal

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                subList.add(cur.val);
            }
            res.add(subList);
        }
        return res;
    }
}
