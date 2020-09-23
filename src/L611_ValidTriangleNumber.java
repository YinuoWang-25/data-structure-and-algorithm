// 611. Valid Triangle Number

import java.util.Arrays;

public class L611_ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int k = nums.length - 1; k > 1; k--) {
            for (int i = 0, j = k - 1; i < j; ) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
