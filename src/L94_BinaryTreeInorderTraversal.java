// 94. Binary Tree Inorder Traversal

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
