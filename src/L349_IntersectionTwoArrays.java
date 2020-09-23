// 349. Intersection of Two Arrays

import java.util.HashSet;
import java.util.Set;

public class L349_IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int value : nums1) {
            set.add(value);
        }
        for (int value : nums2) {
            if (set.contains(value)) {
                intersect.add(value);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}
