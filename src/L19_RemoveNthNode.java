// 19. Remove Nth Node From End of List

import common.ListNode;

public class L19_RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0), preDelete = dummy;
        dummy.next = head;
        for (int i = 0; i < n; i++) {
            if (head == null) return null;
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
