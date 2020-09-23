// 284. Peeking Iterator

import java.util.Iterator;

public class L284_PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer first;

    public L284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        first = null;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        hasNext();
        return first;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        hasNext();
        int res = first;
        first = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        if (first == null && iter.hasNext()) {
            first = iter.next();
        }
        return first != null;
    }
}
