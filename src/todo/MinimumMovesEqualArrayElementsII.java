package todo;

public class MinimumMovesEqualArrayElementsII {
    // 462. Minimum Moves to Equal Array Elements II
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
