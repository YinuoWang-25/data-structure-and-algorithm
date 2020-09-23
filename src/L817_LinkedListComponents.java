// 817. Linked List Components

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class L817_LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (Integer g : G) {
            set.add(g);
        }

        int res = 0;
        while (head != null) {
            ListNode cur = head;
            while (cur != null && set.contains(cur.val)) {
                set.remove(cur.val);
                cur = cur.next;
            }
            if (cur != head) {
                res++;
            }
            if (cur != null) cur = cur.next;
            head = cur;
        }
        return res;
    }
}
