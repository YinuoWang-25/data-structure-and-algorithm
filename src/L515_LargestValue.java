import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 515. Find Largest Value in Each Tree Row
public class L515_LargestValue {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int queueSize = 1;
        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largestElement);
            queueSize = queue.size();
        }
        return res;
    }
}
