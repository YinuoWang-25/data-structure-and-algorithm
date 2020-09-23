package todo;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();

        Set<Integer> delete = new HashSet<>();
        for (int d : to_delete) {
            delete.add(d);
        }
        dfs(root, res, delete);
        return res;
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> res, Set<Integer> delete) {
        if (root == null) {
            return null;
        }
        TreeNode l = dfs(root.left, res, delete);
        TreeNode r = dfs(root.right, res, delete);
        if (delete.contains(root.val)) {
            if (l != null) {
                res.add(l);
            }
            if (r != null) {
                res.add(r);
            }
            return null;
        } else {
            root.left = l;
            root.right = r;
            return root;
        }
    }
}
