// 1249. Minimum Remove to Make Valid Parentheses

/*

Two way check:
1. from left to right, and delete all invalid close Parentheses
2. from right to left, and delete all invalid open Parentheses

*/

import java.util.Deque;
import java.util.LinkedList;

public class L1249_MakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (close < open) {
                    stack.offerFirst(c);
                    close++;
                }
            } else {
                stack.offerFirst(c);
                open += c == '(' ? 1 : 0;
            }
        }

        open = 0;
        close = 0;

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            char c = stack.pollFirst();
            if (c == '(') {
                if (open < close) {
                    sb.append(c);
                    open++;
                }
            } else {
                sb.append(c);
                close += c == ')' ? 1 : 0;
            }
        }
        return sb.reverse().toString();
    }
}
