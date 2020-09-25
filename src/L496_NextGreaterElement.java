// 496. Next Greater Element I
/*
1. We build the map based on num2's larger element relationship
2. we check and build result array based on map

ascending stack
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class L496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peekFirst() < num)
                map.put(stack.pollFirst(), num);
            stack.offerFirst(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
