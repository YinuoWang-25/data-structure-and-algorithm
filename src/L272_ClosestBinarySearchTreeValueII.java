// 272. Closest Binary Search Tree Value II

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L272_ClosestBinarySearchTreeValueII {

    /*

    Recursive

     */
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


    /*

    Iterative

     */

    public List<Integer> closestKValuesII(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<Integer> queue = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();


        pushAll(stack, root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();

            if (queue.size() == k) {
                if (Math.abs(target - queue.peekFirst()) <= Math.abs(target - cur.val)) {
                    break;
                } else {
                    queue.pollFirst();
                }
            }

            queue.offerLast(cur.val);
            pushAll(stack, cur.right);
        }

        return new ArrayList<>(queue);

    }

    private void pushAll(Deque<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}
