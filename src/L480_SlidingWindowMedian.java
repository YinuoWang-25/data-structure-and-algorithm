// 480. Sliding Window Median

import java.util.Comparator;
import java.util.TreeSet;

public class L480_SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
            else return a - b;
        };
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed()), right = new TreeSet<>(comparator);
        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) left.add(i);
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
        res[0] = getMedian(k, nums, left, right);

        int r = 1;
        for (int i = k; i < nums.length; i++, r++) {
            if (!left.remove(i - k)) right.remove(i - k);
            right.add(i);
            left.add(right.pollFirst());
            if (left.size() > right.size()) right.add(left.pollFirst());
            res[r] = getMedian(k, nums, left, right);
        }

        return res;
    }

    private double getMedian(int k, int[] nums, TreeSet<Integer> left, TreeSet<Integer> right) {
        if (k % 2 == 0) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        } else {
            return nums[right.first()];
        }
    }
}
