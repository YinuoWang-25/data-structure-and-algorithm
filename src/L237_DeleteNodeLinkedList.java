// 237. Delete Node in a Linked List

import common.ListNode;

public class L237_DeleteNodeLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
