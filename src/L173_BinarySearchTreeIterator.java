// 173. Binary Search Tree Iterator

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L173_BinarySearchTreeIterator {
    Deque<TreeNode> stack;

    public L173_BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        pushAll(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pollFirst();
        pushAll(cur.right);
        return cur.val;
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
