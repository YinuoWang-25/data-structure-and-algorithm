// 429. N-ary Tree Level Order Traversal

import common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L429_NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int sz = q.size();
            LinkedList<Integer> curLevel = new LinkedList<Integer>();
            while (sz > 0) {
                Node curNode = q.poll();
                curLevel.add(curNode.val);
                for (Node child : curNode.children) {
                    q.offer(child);
                }
                sz--;
            }
            res.add(curLevel);
        }
        return res;
    }
}
