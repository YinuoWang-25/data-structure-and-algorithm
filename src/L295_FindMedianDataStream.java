// 295. Find Median from Data Stream
/*
We maintain two heap, one max heap to store first part and one min heap to store second part

Every time we offer it in max heap or min heap comparing it with top value

Keep in mind that the size of two heap can not larger than 1
 */

import java.util.PriorityQueue;

public class L295_FindMedianDataStream {
    PriorityQueue<Integer> maxHeap; // first part
    PriorityQueue<Integer> minHeap;// second part

    /**
     * initialize your data structure here.
     */
    public L295_FindMedianDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() - 1 > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
