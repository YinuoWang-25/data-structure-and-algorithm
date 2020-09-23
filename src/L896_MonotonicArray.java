// 896. Monotonic Array

public class L896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean isInc = true, isDec = true;
        for (int i = 1; i < A.length; ++i) {
            isInc &= A[i - 1] <= A[i];
            isDec &= A[i - 1] >= A[i];
        }
        return isInc || isDec;
    }
}
