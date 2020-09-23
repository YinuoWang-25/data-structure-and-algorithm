package todo;

import java.util.HashMap;
import java.util.Map;

public class MinimumDominoRotations {
    // 1007. Minimum Domino Rotations For Equal Row

    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) return -1;
        int forA = getMin(A, B);
        int forB = getMin(B, A);
        if (forA == -1 && forB == -1) return -1;
        if (forA == -1 || forB == -1) return forA + forB + 1;
        return Math.min(forA, forB);

    }

    private int getMin(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int most = -1;
        int num = 0;

        for (int key : map.keySet()) {
            if (most < map.get(key) ) {
                most = map.get(key);
                num = key;
            }

        }

        int res = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == num) continue;
            else {
                if (B[i] != num) {
                    return -1;
                } else {
                    res++;
                }
            }
        }
        return res;
    }

}
