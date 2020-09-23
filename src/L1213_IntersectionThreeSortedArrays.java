// 1213. Intersection of Three Sorted Arrays

import java.util.ArrayList;
import java.util.List;

public class L1213_IntersectionThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int a = 0, b = 0, c = 0;
        List<Integer> res = new ArrayList<>();
        while (a < arr1.length && b < arr2.length && c < arr3.length) {
            int min = Math.min(arr1[a], Math.min(arr2[b], arr3[c]));
            if (arr1[a] == min && arr2[b] == min && arr3[c] == min) res.add(min);
            if (arr1[a] == min) a++;
            if (arr2[b] == min) b++;
            if (arr3[c] == min) c++;
        }
        return res;
    }
}
