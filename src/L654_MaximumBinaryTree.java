// 654. Maximum Binary Tree

import common.TreeNode;

public class L654_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int idx = left;
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, left, idx - 1);
        root.right = build(nums, idx + 1, right);
        return root;
    }
}
