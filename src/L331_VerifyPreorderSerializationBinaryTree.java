// 331. Verify Preorder Serialization of a Binary Tree

import java.util.Deque;
import java.util.LinkedList;

public class L331_VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        for (String str : strs) {
            if (str.equals("#")) {
                while (!stack.isEmpty() && stack.peekFirst().equals("#")) {
                    stack.pollFirst();
                    if (stack.isEmpty() || stack.peekFirst().equals("#"))
                        return false;
                    stack.pollFirst();
                }

            }
            stack.offerFirst(str);
        }
        return stack.size() == 1 && stack.peekFirst().equals("#");
    }
}
