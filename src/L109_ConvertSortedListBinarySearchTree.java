// 109. Convert Sorted List to Binary Search Tree

import common.ListNode;
import common.TreeNode;

public class L109_ConvertSortedListBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode pre = findMiddle(head);
        ListNode rootNode = pre.next;

        pre.next = null;

        ListNode rightNode = rootNode.next;

        TreeNode root = new TreeNode(rootNode.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightNode);

        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
