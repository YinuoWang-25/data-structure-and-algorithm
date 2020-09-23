// 2. Add Two Numbers

import common.ListNode;

public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int val = 0;
        while (l1 != null || l2 != null || val != 0) {
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            val = val / 10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
