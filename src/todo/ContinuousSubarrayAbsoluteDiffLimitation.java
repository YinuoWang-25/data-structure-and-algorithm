package todo;

import java.util.Deque;
import java.util.LinkedList;

public class ContinuousSubarrayAbsoluteDiffLimitation {
    public int longestSubarray(int[] arr, int limit) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        while (right < arr.length) {
            while (!max.isEmpty() && arr[right] > max.peekLast()) {
                max.pollLast();
            }
            max.offerLast(arr[right]);
            while (!min.isEmpty() && arr[right] < min.peekLast()) {
                min.pollLast();
            }
            min.offerLast(arr[right]);
            right++;
            int curMax = max.peekFirst();
            int curMin = min.peekFirst();
            while (curMax - curMin > limit) {
                if (max.peekFirst() == arr[left]) {
                    max.pollFirst();
                    curMax = max.peekFirst();
                }
                if (min.peekFirst() == arr[left]) {
                    min.pollFirst();
                    curMin = min.peekFirst();
                }
                left++;
            }
            if (curMax - curMin <= limit) {
                ans = Math.max(ans, right - left );
            }
        }
        return ans;
    }
}
