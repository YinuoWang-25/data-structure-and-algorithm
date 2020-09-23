// 116. Populating Next Right Pointers in Each MyNode
/*
We use two pointers to mark two layers: parent and next.
parent layer is set up already, so we currently will take care of next layer

We have a pointer prev which is the prev pointer for current node
 */


import common.MyNode;

public class L116_PopulatingNextRightPointers {

    public MyNode connect(MyNode root) {
        if (root == null) {
            return root;
        }
        MyNode parent = root;
        MyNode next = parent.left;
        while (parent != null && next != null) {
            MyNode prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                } else {
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
        return root;
    }
}

