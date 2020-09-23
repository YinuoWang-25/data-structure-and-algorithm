// 719. Find K-th Smallest Pair Distance

import java.util.Arrays;

/*
Intuition: using value binary search
 1. sort input array nums and we can get low bound and high bound for distance
 2. do binary search based on low bound and high bound:
    a. for mid, we count distance pairs amount whose distance is les or equals to mid count:
        i> if count < k, it means that our distance is not big enough, so we do low = mid + 1
        ii> count >= k, it might be the answer but we need to move right to mid
        Note: we can not stop when count == k, because it might not one distance

How to count less pair:
    for every num, we find the upper bound who can make the dist <= mid

How we search upper bound:
    we know it is smaller than or equals to num + mid
    So we can do binary search to find the first element who is larger than num + mid
*/

public class L719_SmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        // Minimum and max absolute difference
        int low = nums[1] - nums[0], high = nums[n - 1] - nums[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, nums[i + 1] - nums[i]);

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // Returns number of pairs with absolute difference less than or equal to mid.
    private int countPairs(int[] nums, int bound) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int right = getUpperBound(nums, i, nums.length - 1, bound + nums[i]);
            res += right - i - 1;
        }
        return res;
    }

    // Returns index of first index of element which is greater than key
    private int getUpperBound(int[] nums, int low, int high, int key) {
        if (nums[high] <= key) return high + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= nums[mid]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
