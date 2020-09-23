// 845. Longest Mountain in Array

/**
 * One pass to solve the problem. For every start point:
 * 1. we climb and note up
 * 2. then we go down and note down
 * 3. check if up > 0 && down > 0
 * Note we need to ignore all same range
 */

public class L845_LongestMountainArray {
    public int longestMountain(int[] A) {
        int maxMnt = 0, i = 1;
        while (i < A.length) {
            int up = 0, down = 0;
            while (i < A.length && A[i - 1] == A[i]) i++;
            while (i < A.length && A[i - 1] < A[i]) {
                ++up;
                ++i;
            }
            while (i < A.length && A[i - 1] > A[i]) {
                ++down;
                ++i;
            }
            if (up > 0 && down > 0) maxMnt = Math.max(maxMnt, up + down + 1);
        }
        return maxMnt;
    }
}
