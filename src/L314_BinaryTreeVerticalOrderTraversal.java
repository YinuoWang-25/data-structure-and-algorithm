// 314. Binary Tree Vertical Order Traversal

import common.TreeNode;

import java.util.*;

public class L314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        nodeQueue.add(root);
        colQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            int curCol = colQueue.poll();
            map.putIfAbsent(curCol, new ArrayList<>());
            map.get(curCol).add(curNode.val);

            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                colQueue.offer(curCol - 1);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                colQueue.offer(curCol + 1);
            }
        }

        for (Integer key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
