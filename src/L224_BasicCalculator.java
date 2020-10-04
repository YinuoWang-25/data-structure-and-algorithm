// 224. Basic Calculator
/*
Assumption: input s is valid
 */

import java.util.Deque;
import java.util.LinkedList;

public class L224_BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>(), signs = new LinkedList<>();
        int res = 0, sign = 1, num = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                nums.offerFirst(res);
                signs.offerFirst(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += num * sign;
                res = nums.pollFirst() + signs.pollFirst() * res;
                sign = 1;
                num = 0;
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
        }
        if (num > 0) res += num * sign;
        return res;
    }
}
