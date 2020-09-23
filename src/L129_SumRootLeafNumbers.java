// 129. Sum Root to Leaf Numbers

import common.TreeNode;

public class L129_SumRootLeafNumbers {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return ans;
    }

    public void helper(TreeNode root, String tmp) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            tmp += String.valueOf(root.val);
            ans += Integer.valueOf(tmp);
        }
        helper(root.left, tmp + root.val);
        helper(root.right, tmp + root.val);

    }
}
