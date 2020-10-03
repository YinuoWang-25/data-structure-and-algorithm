// 1004. Max Consecutive Ones III
public class L1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, len = 0, count = 0;
        while (right < A.length) {
            if (A[right] == 0) count++;
            right++;
            while (count > K) {
                if (A[left] == 0) count--;
                left++;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
