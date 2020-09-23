// 167. Two Sum II - Input array is sorted

public class L167_TwoSumII {
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) return new int[0];

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                int[] ans = new int[2];
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (sum < target) left++;
            else right--;
        }
        return new int[0];
    }
}
