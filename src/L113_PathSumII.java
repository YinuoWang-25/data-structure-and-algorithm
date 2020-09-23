// 113. Path Sum II

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        getSum(ans, new ArrayList<>(), root, sum);
        return ans;
    }

    private void getSum(List<List<Integer>> ans, List<Integer> cur, TreeNode node, int sum) {
        if (node == null) return;
        cur.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                ans.add(new ArrayList<>(cur));
            }
        } else {
            getSum(ans, cur, node.left, sum - node.val);
            getSum(ans, cur, node.right, sum - node.val);
        }
        cur.remove(cur.size() - 1);
    }
}
