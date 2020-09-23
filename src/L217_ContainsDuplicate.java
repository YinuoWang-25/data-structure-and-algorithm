// 217. Contains Duplicate

import java.util.HashSet;
import java.util.Set;

public class L217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }
}
