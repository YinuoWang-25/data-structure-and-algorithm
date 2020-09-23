// 382. Linked List Random Node

import common.ListNode;

import java.util.Random;

public class L382_RandomNode {
    ListNode head;
    Random rand;

    public L382_RandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode cur = null;
        ListNode node = head;
        int sum = 1;
        while (node != null) {
            int index = rand.nextInt(sum);
            if (index == 0) {
                cur = node;
            }
            sum++;
            node = node.next;
        }
        return cur.val;
    }
}
