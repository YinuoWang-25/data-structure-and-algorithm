// 549. Binary Tree Longest Consecutive Sequence II

import common.TreeNode;

public class L549_LongestConsecutiveSequenceII {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    // result[0]: increasing
    // result[1]: decreasing
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] lefts = dfs(root.left), rights = dfs(root.right);
        int localInc = 1, localDec = 1;
        if (root.left != null) {
            if ( root.val == root.left.val + 1) {
                localInc += lefts[0];
            } else if (root.val == root.left.val - 1) {
                localDec += lefts[1];
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val + 1) {
                localInc = Math.max(localInc, rights[0] + 1);
            } else if (root.val == root.right.val - 1) {
                localDec = Math.max(localDec, rights[1] + 1);
            }
        }
        max = Math.max(max, localInc + localDec - 1);

        return new int[]{localInc, localDec};
    }
}
