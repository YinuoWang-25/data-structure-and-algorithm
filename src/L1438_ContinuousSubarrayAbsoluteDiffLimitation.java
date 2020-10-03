// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

import java.util.Deque;
import java.util.LinkedList;

public class L1438_ContinuousSubarrayAbsoluteDiffLimitation {
    public int longestSubarray(int[] arr, int limit) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0, right = 0, ans = 0;
        Deque<Integer> max = new LinkedList<>(), min = new LinkedList<>();
        while (right < arr.length) {
            while (!max.isEmpty() && arr[right] > max.peekLast()) max.pollLast();
            while (!min.isEmpty() && arr[right] < min.peekLast()) min.pollLast();
            max.offerLast(arr[right]);
            min.offerLast(arr[right]);
            right++;
            int curMax = max.peekFirst(), curMin = min.peekFirst();
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
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
