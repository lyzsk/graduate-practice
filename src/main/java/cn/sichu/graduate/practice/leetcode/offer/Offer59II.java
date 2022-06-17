package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author sichu
 * @date 2022/06/17
 */
public class Offer59II {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public Offer59II() {
        this.queue = new ArrayDeque<Integer>();
        this.deque = new ArrayDeque<Integer>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.poll();
        if (res == deque.peekFirst()) {
            deque.pollFirst();
        }
        return res;
    }
}
