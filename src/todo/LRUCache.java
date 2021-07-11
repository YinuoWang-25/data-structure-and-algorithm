package todo;
// 146. LRU Cache

import java.util.Map;

public class L146_LRUCache {
    class Node<K, V> {
        Node<Integer, Integer> next;
        Node<Integer, Integer> prev;
        Integer key;
        Integer value;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        void update(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;
    private Map<Integer, Node<Integer, Integer>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if (map.size() < capacity) {
            node = new Node(key, value);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }

    private Node remove(Node node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.next = node.prev = null;
        return node;
    }

    private Node append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
}
