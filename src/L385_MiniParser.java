// 385. Mini Parser

import common.NestedInteger;

import java.util.Deque;
import java.util.LinkedList;

public class L385_MiniParser {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> stack = new LinkedList<>();
        NestedInteger curr = null;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) stack.push(curr);
                curr = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty())
                    curr.add(new NestedInteger(Integer.parseInt(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pollFirst();
                    pop.add(curr);
                    curr = pop;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r - 1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.parseInt(num)));
                }
                l = r + 1;
            }
        }
        return curr;
    }
}
