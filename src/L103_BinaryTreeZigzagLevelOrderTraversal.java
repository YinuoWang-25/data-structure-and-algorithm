// 103. Binary Tree Zigzag Level Order Traversal

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode cur = deque.pollLast();
                    if (cur.left != null) {
                        deque.addFirst(cur.left);
                    }
                    if (cur.right != null) {
                        deque.addFirst(cur.right);
                    }
                    curList.add(cur.val);
                } else {
                    TreeNode cur = deque.pollFirst();
                    if (cur.right != null) {
                        deque.addLast(cur.right);
                    }
                    if (cur.left != null) {
                        deque.addLast(cur.left);
                    }
                    curList.add(cur.val);
                }

            }
            leftToRight = !leftToRight;
            res.add(curList);
        }
        return res;
    }
}
