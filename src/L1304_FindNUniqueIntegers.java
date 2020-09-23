// 1304. Find N Unique Integers Sum up to Zero

public class L1304_FindNUniqueIntegers {
    public int[] sumZero(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = i * 2 - n + 1;
        return A;
    }
}
