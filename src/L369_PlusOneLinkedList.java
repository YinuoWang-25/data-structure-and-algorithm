// 369. Plus One Linked List

import common.ListNode;

public class L369_PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null) {
            if (fast.val != 9) slow = fast;
            fast = fast.next;
        }
        slow.val = slow.val + 1;
        fast = slow.next;
        while (fast != null) {
            fast.val = 0;
            fast = fast.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}
