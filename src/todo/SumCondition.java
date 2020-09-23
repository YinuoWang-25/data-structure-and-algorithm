package todo;

import java.util.Arrays;

public class SumCondition {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1, mod = (int) (1e9 + 7);
        int res = 0;
        int[] pow = new int[n + 1];
        pow[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        Arrays.sort(nums);
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
