// 230. Kth Smallest Element in a BST

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L230_KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode curNode = stack.pollFirst();
            k--;

            if (k == 0) {
                return curNode.val;
            }

            TreeNode right = curNode.right;

            while (right != null) {
                stack.offerFirst(right);
                right = right.left;
            }
        }

        return -1;
    }
}
