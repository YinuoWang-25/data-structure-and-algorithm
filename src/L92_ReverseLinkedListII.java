// 92. Reverse Linked List II

import common.ListNode;

public class L92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (m > 1) {
            pre = pre.next;
            m--;
            n--;
        }
        ListNode last = pre.next;
        ListNode cur = pre.next;
        while (cur != null && n > 0) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            n--;
        }
        last.next = cur;
        return dummy.next;
    }
}
