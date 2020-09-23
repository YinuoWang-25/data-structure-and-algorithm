// 232. Implement Queue using Stacks

import java.util.Stack;

public class L232_MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public L232_MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int res = stack1.pop();
        stack2.push(res);
        return res;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
