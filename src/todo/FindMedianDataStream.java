package todo;

public class FindMedianDataStream {
    // 295. Find Median from Data Stream
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a, b) -> ( b - a)); // first part
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // second part

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            while (maxHeap.size() - 1 > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            while (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 == 0) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
