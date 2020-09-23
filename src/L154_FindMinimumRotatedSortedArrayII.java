// 154. Find Minimum in Rotated Sorted Array II

public class L154_FindMinimumRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }
}
