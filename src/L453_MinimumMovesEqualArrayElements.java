// 453. Minimum Moves to Equal Array Elements

public class L453_MinimumMovesEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
