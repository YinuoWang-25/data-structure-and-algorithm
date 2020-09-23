// 238. Product of Array Except Self
/*
    Tow way check:
    1. from left to right, we need to calculate product in [0, i). So res[i] = res[i - 1] * nums[i - 1]
    2. from right to left, we need to calculate product in (i, nums.length - 1] and multiple it with res[i] to get the answer
 */
public class L238_ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
