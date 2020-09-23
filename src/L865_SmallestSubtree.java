import common.TreeNode;
import javafx.util.Pair;

/*

For every node, we get max depth and min sub tree node from left and right

case 1: left max depth == right max depth, we return root as new sub tree node
case 2: left max depth < right max depth, we return sub tree node from right
case 3: left max depth > right max depth, we return sub tree node from left

 */

public class L865_SmallestSubtree {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
