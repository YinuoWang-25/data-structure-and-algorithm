// 268. Missing Number

public class L268_MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for (int num : nums) sum -= num;
        return sum;
    }
}
