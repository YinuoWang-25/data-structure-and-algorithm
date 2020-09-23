import common.ListNode;
// 24. Swap Nodes in Pairs

public class L24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = swapPairs(head.next.next);
        ListNode res = head.next;
        head.next.next = head;
        head.next = next;
        return res;
    }
}
