// 287. Find the Duplicate Number

public class L287_FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int small = 0;
            for (int num : nums) {
                small += num <= mid ? 1 : 0;
            }
            if (small <= mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
