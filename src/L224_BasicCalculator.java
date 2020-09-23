// 224. Basic Calculator

import java.util.Deque;
import java.util.LinkedList;

public class L224_BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> preStack = new LinkedList<>();
        Deque<Integer> signStack = new LinkedList<>();
        int pre = 0;
        int sign = 1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                pre += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                pre += sign * num;
                num = 0;
                sign = -1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                preStack.offerFirst(pre);
                signStack.offerFirst(sign);
                pre = 0;
                sign = 1;
            } else if (c == ')') {
                pre += sign * num;
                pre = preStack.pollFirst() + signStack.pollFirst() * pre;
                sign = 1;
                num = 0;
            }
        }
        if (num > 0) {
            pre += num * sign;
        }
        return pre;
    }
}
