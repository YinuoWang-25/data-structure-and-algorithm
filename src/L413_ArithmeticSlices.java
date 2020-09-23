// 413. Arithmetic Slices
/*
    We keep two variable:
        1. global one for total Arithmetic Slices
        2. local one for consecutive elements ending in nums[i - 1]
 */
public class L413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int global = 0, local = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                local++;
                global += local;
            } else {
                local = 0;
            }
        }
        return global;
    }
}
