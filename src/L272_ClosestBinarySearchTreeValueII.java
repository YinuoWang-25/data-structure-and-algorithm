// 272. Closest Binary Search Tree Value II

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L272_ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> res = new LinkedList<>();
        inorder(root, target, k, res);
        return new ArrayList<>(res);
    }

    private void inorder(TreeNode root, double target, int k, Deque<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, target, k, res);
        if (res.size() == k) {
            if (Math.abs(root.val - target) > Math.abs(res.peekFirst() - target)) {
                return;
            } else {
                res.pollFirst();
            }
        }
        res.offerLast(root.val);
        inorder(root.right, target, k, res);
    }
}
