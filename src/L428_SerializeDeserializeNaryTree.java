// 428. Serialize and Deserialize N-ary Tree

import common.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class L428_SerializeDeserializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        sb.append(",");
        sb.append(root.children.size());
        sb.append(",");
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i), sb);
        }

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] strs = data.split(",");
        if (strs.length == 0) {
            return null;
        }
        Deque<String> q = new LinkedList<>();
        for (String s : strs) {
            q.offer(s);
        }
        return deserialize(q);
    }

    private Node deserialize(Deque<String> data) {
        String str = data.poll();
        Node root = new Node(Integer.parseInt(str));
        int size = Integer.parseInt(data.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            root.children.add(deserialize(data));
        }
        return root;

    }
}
