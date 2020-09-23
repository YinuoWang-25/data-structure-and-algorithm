// 973. K Closest Points to Origin

/*
Typical Kth problem which has two solutions

1. Quick sort: no random pvot logic here, can check: 215. Kth Largest Element in an Array

2. PriorityQueue

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class L973_KClosestPointsOrigin {

    // Quick Sort
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int r = points.length - 1;
        while (l <= r) {
            int mid = partition(points, l, r);
            if (mid == K - 1) break;
            if (mid < K - 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int left, int right) {
        if (left == right) return left;
        int pivot = left;
        left++;
        while (left <= right) {
            while (left <= right && getDist(points[left]) < getDist(points[pivot])) {
                left++;
            }
            while (left <= right && getDist(points[right]) >= getDist(points[pivot])) {
                right--;
            }
            if (left > right) break;
            swap(points, left, right);
        }
        swap(points, pivot, right);
        return right;
    }

    private void swap(int[][] points, int left, int right) {
        int[] tmp = points[left];
        points[left] = points[right];
        points[right] = tmp;
    }


    private int getDist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    // Heap
    public int[][] kClosestII(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, (a, b) -> (a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]));
        int[][] res = new int[K][2];
        for (int[] point : points) {
            pq.offer(new int[]{point[0], point[1]});
        }
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
