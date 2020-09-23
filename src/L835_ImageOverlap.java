// 835. Image Overlap

/*
  1. we put 1s in A and B in to array a and b, respectively
  2. We create a map whose key is the diff key of two point, and value is counter
  3. for every point in a
        for every point in b
            we group them in diff key: diff-x - diff-y
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L835_ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length, ret = 0;
        List<int[]> p1 = new ArrayList<>();
        List<int[]> p2 = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            if (A[i / n][i % n] == 1)
                p1.add(new int[]{i / n, i % n});
            if (B[i / n][i % n] == 1)
                p2.add(new int[]{i / n, i % n});
        }
        Map<String, Integer> diffMap = new HashMap<>();
        for (int[] a : p1) {
            for (int[] b : p2) {
                String diff = "" + (a[0] - b[0]) + "-" + (a[1] - b[1]);
                diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
                ret = Math.max(ret, diffMap.get(diff));
            }
        }
        return ret;
    }
}
