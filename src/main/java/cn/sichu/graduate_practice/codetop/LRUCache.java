package cn.sichu.graduate_practice.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * 频率3
 * <p>
 * https://leetcode-cn.com/problems/lru-cache/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class LRUCache {
    class DeLinkedNode {
        public int key;
        public int value;
        public DeLinkedNode prev;
        public DeLinkedNode next;

        public DeLinkedNode() {
            super();
        }

        public DeLinkedNode(int key, int value) {
            super();
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DeLinkedNode> cache = new HashMap<Integer, DeLinkedNode>();
    private int size;
    private int capacity;
    private DeLinkedNode head;
    private DeLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DeLinkedNode();
        tail = new DeLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            DeLinkedNode newNode = new DeLinkedNode(key, value);
            cache.put(key, newNode);
            addToTail(newNode);
            ++size;
            if (size > capacity) {
                DeLinkedNode head = removeHead();
                cache.remove(head.key);
                --size;
            }
        } else {
            node.value = value;
            moveToTail(node);
        }
    }

    private void addToTail(DeLinkedNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(DeLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToTail(DeLinkedNode node) {
        removeNode(node);
        addToTail(node);
    }

    private DeLinkedNode removeHead() {
        DeLinkedNode res = head.next;
        removeNode(res);
        return res;
    }
}
