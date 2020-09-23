// 215. Kth Largest Element in an Array

/*
Typical Kth problem which has two solutions

    1. Quick sort: no random pvot logic here

    2. PriorityQueue

 */

public class L215_KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        k = nums.length - k;
        while (index != k) {
            index = partition(nums, left, right);
            if (index == k) {
                return nums[index];
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int pivot = l;
        l++;
        while (l <= r) {
            while (l <= r && nums[l] <= nums[pivot]) l++;
            while (l <= r && nums[r] > nums[pivot]) r--;
            if (l > r) break;
            swap(nums, l++, r--);
        }
        swap(nums, pivot, r);
        return r;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
