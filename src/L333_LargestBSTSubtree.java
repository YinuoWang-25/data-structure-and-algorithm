// 333. Largest BST Subtree

import common.TreeNode;

public class L333_LargestBSTSubtree {

    public int largestBSTSubtree(TreeNode root) {
        int[] res = new int[1];

        traverse(res, root);

        return res[0];
    }

    private Result traverse(int[] res, TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = traverse(res, root.left), right = traverse(res, root.right);

        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }

        int size = left.size + 1 + right.size;

        res[0] = Math.max(size, res[0]);

        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    class Result {
        int size;
        int lower;
        int upper;

        public Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
