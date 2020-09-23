// 300. Longest Increasing Subsequence

import java.util.Arrays;

public class L300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] bucks = new int[nums.length + 1];
        Arrays.fill(bucks, Integer.MAX_VALUE);
        for (int num : nums) {
            // find the first number which is bigger then nums[i];
            int left = 0;
            int right = bucks.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (bucks[mid] >= num) right = mid;
                else left = mid + 1;
            }
            bucks[left] = num;
        }
        for (int i = bucks.length - 1; i >= 0; i--) {
            if (bucks[i] < Integer.MAX_VALUE) {
                return i + 1;
            }
        }
        return 0;
    }
}
