// 487. Max Consecutive Ones II

public class L487_MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, zero = 0, res = 0;
        while (right < nums.length) {
            zero += nums[right] == 0 ? 1 : 0;
            right++;
            while (zero > 1) {
                zero -= nums[left] == 0 ? 1 : 0;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int findMaxConsecutiveOnesII(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];

        lefts[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = nums[i] == 1 ? lefts[i - 1] + 1 : 0;
        }

        rights[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rights[i] = nums[i] == 1 ? rights[i + 1] + 1 : 0;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max = Math.max(max, lefts[i]);
            } else {
                int tmp = 1;
                if (i > 0) {
                    tmp += lefts[i - 1];
                }
                if (i < nums.length - 1) {
                    tmp += rights[i + 1];
                }
                max = Math.max(max, tmp);
            }
        }
        return max;
    }
}
