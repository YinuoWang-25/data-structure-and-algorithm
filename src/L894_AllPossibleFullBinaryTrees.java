// 894. All Possible Full Binary Trees

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L894_AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N--;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> lefts = allPossibleFBT(i), rights = allPossibleFBT(N - i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    res.add(new TreeNode(0, left, right));
                }
            }
        }
        return res;
    }

}
