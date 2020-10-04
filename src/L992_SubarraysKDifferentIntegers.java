// 992. Subarrays with K Different Integers
/*
need a helper function to calculate atMost: in the sliding window, there are at most k element

So Subarrays with K Different Integers = atMost(k) - atMost(k - 1)

 */


public class L992_SubarraysKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }

    public int atMost(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        int res = 1, left = 0;
        int[] count = new int[A.length + 1];
        for (int right = 0; right < A.length; right++) {
            if (++count[A[right]] == 1) K--;
            while (K < 0) {
                if (--count[A[left++]] == 0) K++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
