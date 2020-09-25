// 674. Longest Continuous Increasing Subsequence

public class L674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
                res = Math.max(res, cur);
            } else cur = 1;
        }
        return res;
    }
}
