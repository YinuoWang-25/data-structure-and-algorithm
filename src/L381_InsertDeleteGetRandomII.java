// 381. Insert Delete GetRandom O(1) - Duplicates allowed
/*
Compared with Insert Delete GetRandom O(1), the difference sits in remove process. When we try to find the last
element in list and put it in removed index, we don't know how to update it in map. So in list, we not on store the values we
would like to keep, but also the index of it in map's corresponding list
 */

import java.util.*;

public class L381_InsertDeleteGetRandomII {
    // pair.number is the number, pair.index is the index in map value
    private final List<NumberAndIndex> nums;
    // key is the number, value is the indices list in nums;
    private final Map<Integer, List<Integer>> map;
    private final Random rand;

    /**
     * Initialize your data structure here.
     */
    public L381_InsertDeleteGetRandomII() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean existed = map.containsKey(val);

        if (!existed) map.put(val, new ArrayList<>());
        List<Integer> indices = map.get(val);
        indices.add(nums.size());
        nums.add(new NumberAndIndex(val, indices.size() - 1));

        return !existed;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        List<Integer> indices = map.get(val);
        int index = indices.get(indices.size() - 1);

        NumberAndIndex numIndex = nums.get(nums.size() - 1);
        nums.set(index, numIndex);
        nums.remove(nums.size() - 1);
        map.get(numIndex.number).set(numIndex.index, index);

        indices.remove(indices.size() - 1);
        if (indices.size() == 0) {
            map.remove(val);
        }

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int index = rand.nextInt(nums.size());
        return nums.get(index).number;
    }
}

class NumberAndIndex {
    public int number, index;

    public NumberAndIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }
}
