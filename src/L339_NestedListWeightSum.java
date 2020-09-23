// 339. Nested List Weight Sum

import common.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L339_NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int sum = 0, level = 1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) sum += cur.getInteger() * level;
                else queue.addAll(cur.getList());
            }
            level++;
        }
        return sum;
    }
}
