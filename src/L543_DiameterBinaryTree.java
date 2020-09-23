// 543. Diameter of Binary Tree

import common.TreeNode;

public class L543_DiameterBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ReturnValue res = helper(root);
        return res.total - 1;
    }

    private ReturnValue helper(TreeNode root) {
        if (root == null) {
            return new ReturnValue(0, 0);
        }
        ReturnValue left = helper(root.left);
        ReturnValue right = helper(root.right);
        int single = Math.max(left.single, right.single) + 1;
        int total = Math.max(left.total, right.total);
        int curTotal = left.single + right.single + 1;
        total = Math.max(total, curTotal);
        return new ReturnValue(total, single);
    }
}

class ReturnValue {
    public int total;
    public int single;

    public ReturnValue(int total, int single) {
        this.total = total;
        this.single = single;
    }
}
