package cn.sichu.graduate.practice.codetop.swe;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0001 {
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

    private int size = 0;
    private int capacity = 0;
    private Map<Integer, DeLinkedNode> cache = new HashMap<Integer, DeLinkedNode>();
    private DeLinkedNode dummyhead;
    private DeLinkedNode dummytail;

    public CodeTop0001(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.dummyhead = new DeLinkedNode();
        this.dummytail = new DeLinkedNode();
        dummyhead.next = dummytail;
        dummytail.prev = dummyhead;
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
        node.prev = dummyhead;
        node.next = dummyhead.next;
        dummyhead.next.prev = node;
        dummyhead.next = node;
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
        DeLinkedNode res = dummytail.prev;
        removeNode(res);
        return res;
    }
}
