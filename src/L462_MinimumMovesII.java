// 462. Minimum Moves to Equal Array Elements II

import java.util.Arrays;

public class L462_MinimumMovesII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int middle = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - middle);
        }
        return res;
    }
}
