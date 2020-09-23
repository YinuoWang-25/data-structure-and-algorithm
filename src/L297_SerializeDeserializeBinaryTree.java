// 297. Serialize and Deserialize Binary Tree

/*
    serialize and deserialize the binary tree in pre-order way. Do it recursively
 */

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L297_SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
        } else {
            sb.append(root.val);
            sb.append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Deque<String> q = new LinkedList<>();
        for (String s : strs) {
            q.offer(s);
        }
        return deserialize(q);
    }

    private TreeNode deserialize(Deque<String> data) {
        String str = data.poll();
        if (str.equals("#")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = deserialize(data);
            root.right = deserialize(data);
            return root;
        }
    }
}
