// 962. Maximum Width Ramp

import java.util.Deque;
import java.util.LinkedList;

public class L962_MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        Deque<Integer> s = new LinkedList<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i)
            if (s.isEmpty() || A[s.peekFirst()] > A[i]) s.offerFirst(i);
        for (int i = n - 1; i > res; --i)
            while (!s.isEmpty() && A[s.peekFirst()] <= A[i])
                res = Math.max(res, i - s.pollFirst());
        return res;
    }
}
