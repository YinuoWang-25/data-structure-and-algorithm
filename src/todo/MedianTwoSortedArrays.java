package todo;
// 4. Median of Two Sorted Arrays

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart > a.length - 1) return a[bStart + k - 1];
        if (bStart > b.length - 1) return b[aStart + k - 1];
        if (k == 1) return Math.min(a[aStart], b[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < a.length) aMid = a[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < b.length) bMid = b[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(a, aStart + k / 2, b, bStart, k - k / 2);
        else
            return getkth(a, aStart, b, bStart + k / 2, k - k / 2);
    }
}
