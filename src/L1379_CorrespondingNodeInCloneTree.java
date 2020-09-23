// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree

import common.TreeNode;

public class L1379_CorrespondingNodeInCloneTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return right;
    }
}
