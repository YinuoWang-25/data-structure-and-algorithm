// 706. Design HashMap

import java.util.Arrays;

public class L706_DesignHashMap {
    int[] nums;

    /**
     * Initialize your data structure here.
     */
    public L706_DesignHashMap() {
        nums = new int[1000001];
        Arrays.fill(nums, -1);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        nums[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return nums[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        nums[key] = -1;
    }
}
