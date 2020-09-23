// 138. Copy List with Random Pointer

import common.RandomNode;

import java.util.HashMap;
import java.util.Map;

public class L138_CopyListRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode res = head;
        while (head != null) {
            map.putIfAbsent(head, new RandomNode(head.val));
            if (head.next != null) {
                map.putIfAbsent(head.next, new RandomNode(head.next.val));
                map.get(head).next = map.get(head.next);
            }
            if (head.random != null) {
                map.putIfAbsent(head.random, new RandomNode(head.random.val));
                map.get(head).random = map.get(head.random);
            }
            head = head.next;
        }
        return map.get(res);
    }
}
