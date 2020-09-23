// 75. Sort Colors

public class L75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int zero = 0, one = 0, two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, one, two--);
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
