// 456. 132 Pattern

/*
We keep a descending stack who contains candidates for s2 and s3, and we have a variable called s2 who is the bigeest
s2 candidate for now
 */

import java.util.Deque;
import java.util.LinkedList;

public class L456_OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peekFirst())
                    second = stack.pollFirst();
            }
            stack.offerFirst(nums[i]);
        }
        return false;
    }
}
