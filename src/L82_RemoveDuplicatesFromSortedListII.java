// 82. Remove Duplicates from Sorted List II

import common.ListNode;

public class L82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        // dummy.next = head;

        while (head != null) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                pre.next = slow;
                head = head.next;
                pre = pre.next;
            } else {
                head = fast;
            }
        }
        pre.next = null;
        return dummy.next;
    }
}
