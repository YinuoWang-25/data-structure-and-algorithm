// 703. Kth Largest Element in a Stream

import java.util.PriorityQueue;

public class L703_KthLargestElementInStream {
    PriorityQueue<Integer> q;
    int k;

    public L703_KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int a : nums) {
            add(a);
        }
    }

    public int add(int val) {
        q.offer(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}
