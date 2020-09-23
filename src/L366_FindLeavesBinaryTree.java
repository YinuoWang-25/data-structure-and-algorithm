// 366. Find Leaves of Binary Tree

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L366_FindLeavesBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res), right = dfs(root.right, res), level = Math.max(left, right) + 1;
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(root.val);
        return level;
    }
}
