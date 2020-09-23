// 528. Random Pick with Weight

import java.util.Random;

public class L528_RandomPickWithWeight {
    int[] sum;
    Random rand;

    public L528_RandomPickWithWeight(int[] w) {
        rand = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = w[i] + sum[i - 1];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == target) return mid;
            else if (sum[mid] > target) {
                right = mid;
            } else if (sum[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
