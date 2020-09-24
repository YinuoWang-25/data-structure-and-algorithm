// 862. Shortest Subarray with Sum at Least K

/*
Also check out 209. Minimum Size Subarray Sum
What makes this problem hard is that we have negative values

The idea is similar to maximum value in data stream
 */

import java.util.Deque;
import java.util.LinkedList;

public class L862_ShortestSubarray {
    public int shortestSubarray(int[] A, int K) {
        int[] sums = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        Deque<Integer> q = new LinkedList<>();
        int res = A.length + 2;
        for (int i = 0; i < sums.length; i++) {
            while (q.size() > 0 && sums[i] - sums[q.peekFirst()] >= K) {
                res = Math.min(res, i - q.pollFirst());
            }
            while (q.size() > 0 && sums[i] <= sums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return res <= A.length ? res : -1;
    }
}
