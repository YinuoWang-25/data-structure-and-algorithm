// 1231. Divide Chocolate

public class L1231_DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        K++;
        int lo = Integer.MAX_VALUE, hi = 0;
        for (int val : sweetness) {
            lo = Math.min(lo, val);
            hi += val;
        }

        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (split(sweetness, mid) < K) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private int split(int[] arr, int minSweetness) {
        int cuts = 0, curTotal = 0;
        for (int val : arr) {
            curTotal += val;
            if (curTotal >= minSweetness) {
                cuts++;
                curTotal = 0;
            }
        }
        return cuts;
    }
}
