// 385. Mini Parser

import common.NestedInteger;

import java.util.Deque;
import java.util.LinkedList;

public class L385_MiniParser {
    public NestedInteger deserialize(String s) {
        NestedInteger res = null;
        if (s.length() == 0) return res;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        Deque<NestedInteger> stack = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '[') {
                if (res != null) stack.offerFirst(res);
                res = new NestedInteger();
            } else if (c == ']') {
                if (!stack.isEmpty()) {
                    NestedInteger pre = stack.pollFirst();
                    pre.add(res);
                    res = pre;
                }
            } else if (Character.isDigit(c) || c == '-') {
                int last = index;
                if (c == '-') last++;
                while (last < s.length() && Character.isDigit(s.charAt(last))) last++;
                int num = c == '-' ? -Integer.valueOf(s.substring(index + 1, last)) : Integer.valueOf(s.substring(index, last));
                res.add(new NestedInteger(num));
                index = last - 1;
            }
            index++;
        }
        return res;
    }
}
