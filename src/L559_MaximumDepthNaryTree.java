// 559. Maximum Depth of N-ary Tree

import common.Node;


public class L559_MaximumDepthNaryTree {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int res = 0;
        for (Node c : root.children) {
            int cur = maxDepth(c);
            res = Math.max(res, cur);
        }
        return res + 1;
    }
}
