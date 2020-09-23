// 1570. Dot Product of Two Sparse Vectors

import java.util.HashMap;
import java.util.Map;

public class L1570_SparseVector {

    Map<Integer, Integer> hashedVector = new HashMap<>();

    L1570_SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                hashedVector.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(L1570_SparseVector vec) {
        int productSum = 0;
        for (Integer key : hashedVector.keySet()) {
            if (vec.hashedVector.containsKey(key)) {
                productSum += hashedVector.get(key) * vec.hashedVector.get(key);
            }
        }
        return productSum;
    }
}
