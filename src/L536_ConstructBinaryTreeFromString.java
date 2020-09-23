// 536. Construct Binary Tree from String

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L536_ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        int num = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (s.charAt(i - 1) != ')') {
                    TreeNode cur = new TreeNode(num * sign);
                    stack.offerFirst(cur);
                    num = 0;
                    sign = 1;
                }
            } else if (c == ')') {
                TreeNode cur;
                if (s.charAt(i - 1) == ')') {
                    cur = stack.pollFirst();
                } else {
                    cur = new TreeNode(num * sign);
                }
                TreeNode father = stack.peekFirst();
                if (father.left == null) father.left = cur;
                else father.right = cur;
                num = 0;
                sign = 1;
            } else if (c == '-') sign = -1;
            else num = num * 10 + (c - '0');
        }
        if (num > 0) return new TreeNode(num * sign);
        return stack.pollFirst();
    }
}
