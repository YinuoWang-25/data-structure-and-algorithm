// 20. Valid Parentheses

import java.util.Deque;
import java.util.LinkedList;

public class L20_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else {
                if (stack.isEmpty() || stack.pollFirst() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
