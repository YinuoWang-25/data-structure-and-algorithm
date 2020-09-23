// 384. Shuffle an Array

import java.util.Random;

public class L384_ShuffleArray {
    int[] nums;
    Random rand;

    public L384_ShuffleArray(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        for (int i = 0; i < res.length; i++) {
            int index = rand.nextInt(i + 1);
            swap(res, i, index);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
