// 155. Min Stack

import java.util.Deque;
import java.util.LinkedList;

public class L155_MinStack {
    Deque<Integer> stack;
    int min;

    /**
     * initialize your data structure here.
     */
    public L155_MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.offerFirst(min);
            min = x;
        }
        stack.offerFirst(x);
    }

    public void pop() {
        if (min == stack.pollFirst()) {
            min = stack.pollFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }
}
