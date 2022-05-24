package cn.sichu.graduate.practice.codetop.backend;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0098 {
    class Node {
        private int key;
        private int val;
        private int freq;
        private Node prev;
        private Node next;

        public Node() {
            this.key = -1;
            this.val = -1;
            this.freq = 0;
        }

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    class DoublyLinkedList {
        private Node dummyHead;
        private Node dummyTail;
        private int size;

        public DoublyLinkedList() {
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            size = 0;
        }

        public void addFirst(Node node) {
            Node prevHead = dummyHead.next;
            node.prev = dummyHead;
            dummyHead.next = node;
            node.next = prevHead;
            prevHead.prev = node;
            ++size;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            --size;
        }

        public Node getHead() {
            return dummyHead.next;
        }

        public Node getTail() {
            return dummyTail.prev;
        }
    }

    private int minfreq;
    private int capacity;
    private Map<Integer, Node> keyMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public CodeTop0098(int capacity) {
        this.minfreq = 0;
        this.capacity = capacity;
        keyMap = new HashMap<Integer, Node>();
        freqMap = new HashMap<Integer, DoublyLinkedList>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        int val = node.val;
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).size == 0) {
            freqMap.remove(freq);
            if (minfreq == freq) {
                minfreq += 1;
            }
        }
        DoublyLinkedList list = freqMap.getOrDefault(freq + 1, new DoublyLinkedList());
        list.addFirst(new Node(key, val, freq + 1));
        freqMap.put(freq + 1, list);
        keyMap.put(key, freqMap.get(freq + 1).getHead());
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyMap.containsKey(key)) {
            if (keyMap.size() == capacity) {
                Node node = freqMap.get(minfreq).getTail();
                keyMap.remove(node.key);
                freqMap.get(minfreq).remove(node);
                if (freqMap.get(minfreq).size == 0) {
                    freqMap.remove(minfreq);
                }
            }
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.addFirst(new Node(key, value, 1));
            freqMap.put(1, list);
            keyMap.put(key, freqMap.get(1).getHead());
            minfreq = 1;
        } else {
            Node node = keyMap.get(key);
            int freq = node.freq;
            freqMap.get(freq).remove(node);
            if (freqMap.get(freq).size == 0) {
                freqMap.remove(freq);
                if (minfreq == freq) {
                    minfreq += 1;
                }
            }
            DoublyLinkedList list = freqMap.getOrDefault(freq + 1, new DoublyLinkedList());
            list.addFirst(new Node(key, value, freq + 1));
            freqMap.put(freq + 1, list);
            keyMap.put(key, freqMap.get(freq + 1).getHead());
        }
    }
}
