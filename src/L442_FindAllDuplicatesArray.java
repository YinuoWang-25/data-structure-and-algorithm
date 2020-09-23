// 442. Find All Duplicates in an Array

import java.util.ArrayList;
import java.util.List;

public class L442_FindAllDuplicatesArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            int cur = nums[index];
            if (cur < 0) {
                res.add(Math.abs(num));
            } else {
                nums[index] = -nums[index];
            }

        }
        return res;
    }
}
