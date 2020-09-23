// 144. Binary Tree Preorder Traversal

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> rights = new LinkedList<>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                rights.offerFirst(root.right);
            }
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pollFirst();
            }
        }
        return list;
    }
}
