// 1060. Missing Element in Sorted Array

public class L1060_MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int missing = nums[right] - nums[left] - (right - left);

        if (k > missing) return nums[right] + k - missing;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            missing = nums[mid] - nums[left] - (mid - left);
            if (k > missing) {
                k -= missing;
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] + k;
    }
}
