// 281. Zigzag Iterator

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class L281_ZigzagIterator {
    Deque<Iterator<Integer>> list;

    public L281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        Iterator<Integer> i1 = v1.iterator();
        Iterator<Integer> i2 = v2.iterator();
        if (i1.hasNext()) {
            list.offer(i1);
        }
        if (i2.hasNext()) {
            list.offer(i2);
        }
    }

    public int next() {
        Iterator<Integer> first = list.pollFirst();
        int res = first.next();
        if (first.hasNext()) {
            list.offer(first);
        }
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
