import common.ListNode;
// 203. Remove Linked List Elements

public class L203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) prev.next = cur.next;
            else prev = prev.next;
            cur = prev.next;
        }
        return dummy.next;
    }
}
