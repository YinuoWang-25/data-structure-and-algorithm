// 430. Flatten a Multilevel Doubly Linked List

import java.util.Deque;
import java.util.LinkedList;

public class L430_FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node pre = dummy;
        Deque<Node> stack = new LinkedList<>();
        stack.offerFirst(head);
        while (stack != null) {
            Node cur = stack.pollFirst();
            System.out.println(cur.val);
            pre.next = cur;
            if (cur != null) {
                cur.prev = pre;
            }
            pre = cur;
            if (cur.child == null) {
                if (cur.next != null) {
                    stack.offerFirst(cur.next);
                }
            } else {
                Node tmp = cur.child;
                while (tmp != null) {
                    stack.offerFirst(tmp);
                    tmp = tmp.next;

                }
            }
        }
        return dummy.next;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
