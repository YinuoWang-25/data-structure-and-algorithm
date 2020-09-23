// 117. Populating Next Right Pointers in Each MyNode II

/*

curP always points to last layer which is already set up
nextDummyHead always the prev node of next layer. It is set up by p's set up

 */

import common.MyNode;

public class L117_PopulatingNextRightPointersII {
    public MyNode connect(MyNode root) {
        if (root == null) return null;
        MyNode curP = root;
        MyNode nextDummyHead = new MyNode(0);
        MyNode p = nextDummyHead;
        while (curP != null) {
            if (curP.left != null) {
                p.next = curP.left;
                p = p.next;
            }
            if (curP.right != null) {
                p.next = curP.right;
                p = p.next;
            }
            if (curP.next != null) {
                curP = curP.next;
            } else {
                curP = nextDummyHead.next;
                nextDummyHead.next = null;
                p = nextDummyHead;
            }
        }
        return root;
    }
}
