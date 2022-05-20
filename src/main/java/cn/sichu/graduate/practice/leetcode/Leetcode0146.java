package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class Leetcode0146 {
    class DeLinkedNode {
        private int key;
        private int value;
        private DeLinkedNode prev;
        private DeLinkedNode next;

        public DeLinkedNode() {

        }

        public DeLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, DeLinkedNode> cache = new HashMap<Integer, DeLinkedNode>();
    private DeLinkedNode dummyHead;
    private DeLinkedNode dummyTail;

    public Leetcode0146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new DeLinkedNode();
        dummyTail = new DeLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            DeLinkedNode newNode = new DeLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            ++size;
            if (size > capacity) {
                DeLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DeLinkedNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeNode(DeLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DeLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DeLinkedNode removeTail() {
        DeLinkedNode res = dummyTail.prev;
        removeNode(res);
        return res;
    }
}
