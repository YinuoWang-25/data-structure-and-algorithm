package todo;

public class LongestContinuousIncreasingSubsequence {
    // 674. Longest Continuous Increasing Subsequence
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
                res = Math.max(cur, res);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
