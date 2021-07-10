// 549. Binary Tree Longest Consecutive Sequence II

import common.TreeNode;

public class L549_LongestConsecutiveSequenceII {

    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];

        dfs(res, root);
        
        return res[0];
    }

    // result[0]: increasing
    // result[1]: decreasing
    private int[] dfs(int[] res, TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] lefts = dfs(res, root.left), rights = dfs(res, root.right);

        int localInc = 1, localDec = 1;

        if (root.left != null) {
            if (root.val == root.left.val + 1) {
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

        res[0] = Math.max(res[0], localInc + localDec - 1);

        return new int[]{localInc, localDec};
    }
}
