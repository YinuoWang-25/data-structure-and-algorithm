// 257. Binary Tree Paths

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", root);
        return ans;
    }

    private void dfs(List<String> ans, String cur, TreeNode root) {
        if (root == null) return;
        cur += root.val;
        if (root.left == null && root.right == null) {
            ans.add(cur);
            return;
        }
        cur += "->";
        dfs(ans, cur, root.left);
        dfs(ans, cur, root.right);
    }
}
