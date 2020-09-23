// 32. Longest Valid Parentheses

/*
We have a stack to store all unmatched parentheses.

preLen is the length of pairs we got matched and pop up from stack

When meeting (, we push it in stack

When meeting ), we:
1. check whether there is ) in stack, it yes, we can get a match, if not we set preLen as 0 and continue
2. We poll up the matched (, and contiue to see whether there is any element in stack
    1. if stack is empty, it means that all previous elements are matched. So we can get a total as pre + matched
    2. if not empty, we just got a matched.
 */

import java.util.Deque;
import java.util.LinkedList;

public class L32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int preLen = 0, max = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerFirst(i);
            } else {
                if (stack.isEmpty()) {
                    preLen = 0;
                } else {
                    int pair = stack.pollFirst();
                    int matched = i - pair + 1;
                    if (stack.isEmpty()) {
                        preLen += matched;
                        matched = preLen;
                    } else {
                        matched = i - stack.peekFirst();
                    }
                    max = Math.max(max, matched);
                }
            }
        }
        return max;
    }
}
