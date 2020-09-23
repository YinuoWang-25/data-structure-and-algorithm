// 298. Binary Tree Longest Consecutive Sequence

import common.TreeNode;

public class L298_BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] longest) {
        if (root == null) return 0;
        int ans = 1, plus = 0;
        int left = helper(root.left, longest);
        int right = helper(root.right, longest);
        if (root.left != null && root.left.val == root.val + 1) {
            plus = left;
        }
        if (root.right != null && root.right.val == root.val + 1) {
            plus = Math.max(plus, right);
        }
        ans += plus;
        longest[0] = Math.max(longest[0], ans);
        return ans;
    }
}
