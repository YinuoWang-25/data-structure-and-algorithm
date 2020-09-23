// 83. Remove Duplicates from Sorted List

import common.ListNode;

public class L83_RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val == slow.val) fast = fast.next;
            else {
                slow.next = fast;
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = null;
        return head;
    }
}
