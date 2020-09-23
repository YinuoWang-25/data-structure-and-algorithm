// 1265. Print Immutable Linked List in Reverse

interface ImmutableListNode {
    void printValue(); // print the value of this node.

    ImmutableListNode getNext(); // return the next node.
}

public class L1265_PrintImmutableLinkedList {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
