// 485. Max Consecutive Ones

public class L485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int ans = 0;
        while (left < nums.length) {
            while (left < nums.length && nums[left] != 1) left++;
            if (left == nums.length) return ans;
            right = left;
            while (right < nums.length && nums[right] == 1) right++;
            ans = Math.max(ans, right - left);
            left = right;
        }
        return ans;
    }
}
