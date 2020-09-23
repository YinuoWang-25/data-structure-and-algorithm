package todo;
// 341. Flatten Nested List Iterator

public class FlattenNestedListIterator  implements Iterator<Integer> {
    Deque<NestedInteger> queue;



    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        for (NestedInteger num: nestedList) {
            queue.offerLast(num);
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return  queue.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!queue.isEmpty() && !queue.peekFirst().isInteger()) {
            NestedInteger top = queue.pollFirst();
            List<NestedInteger> list = top.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                queue.offerFirst(list.get(i));
            }
        }
        return !queue.isEmpty();
    }
}
