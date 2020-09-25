// 503. Next Greater Element II

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i % n])
                res[stack.pollFirst()] = nums[i % n];
            stack.offerFirst(i % n);
        }
        return res;
    }
}
