// 147. Insertion Sort List

/*
Every time we insert head in sorted part of list

 */

import common.ListNode;

public class L147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode toInsert = head;
            head = head.next;

            ListNode prev = dummy, cur = prev.next;
            while (cur != null && cur.val < toInsert.val) {
                prev = prev.next;
                cur = cur.next;
            }
            prev.next = toInsert;
            toInsert.next = cur;
        }
        return dummy.next;
    }
}
