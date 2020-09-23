// 255. Verify Preorder Sequence in Binary Search Tree

import java.util.Deque;
import java.util.LinkedList;

public class L255_VerifyPreorderSequenceBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> path = new LinkedList();
        for (int p : preorder) {
            if (p < low) {
                return false;
            }
            while (!path.isEmpty() && p > path.peekFirst()) {
                low = path.pollFirst();
            }
            path.offerFirst(p);
        }
        return true;
    }
}
