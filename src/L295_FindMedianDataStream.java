// 295. Find Median from Data Stream
/*
We maintain two heap, one max heap to store first part and one min heap to store second part

Every time we offer it in max heap or min heap comparing it with top value

Keep in mind that the size of two heap can not larger than 1
 */

import java.util.PriorityQueue;

public class L295_FindMedianDataStream {
    PriorityQueue<Integer> first = new PriorityQueue<>((a, b) -> (b - a));
    PriorityQueue<Integer> second = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public L295_FindMedianDataStream() {

    }

    public void addNum(int num) {
        first.add(num);
        second.add(first.poll());
        if (second.size() > first.size()) first.add(second.poll());
    }

    public double findMedian() {
        int size = first.size() + second.size();
        if (size % 2 == 0) {
            return (double) (first.peek() + second.peek()) / 2;
        } else {
            return first.peek();
        }
    }
}
