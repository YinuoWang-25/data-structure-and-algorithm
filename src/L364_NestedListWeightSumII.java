// 364. Nested List Weight Sum II

import common.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L364_NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger num : nestedList) {
            q.add(num);
        }


        int res = 0, allLevel = 0;

        while (!q.isEmpty()) {
            int sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger cur = q.poll();
                if (cur.isInteger()) {
                    sum += cur.getInteger();
                } else {
                    List<NestedInteger> nexts = cur.getList();
                    for (NestedInteger next : nexts) {
                        q.offer(next);
                    }
                }
            }
            allLevel += sum;
            res += allLevel;
        }
        return res;
    }
}
