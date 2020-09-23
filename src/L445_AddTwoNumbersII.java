// 445. Add Two Numbers II

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class L445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();

        while (l1 != null) {
            s1.offerFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.offerFirst(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pollFirst();
            if (!s2.isEmpty()) sum += s2.pollFirst();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}
