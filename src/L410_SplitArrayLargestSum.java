// 410. Split Array Largest Sum
// same as divide chocolate

public class L410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isValid = valid(mid, nums, m);
            if (isValid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean valid(int target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
