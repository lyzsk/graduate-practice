package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class Offer30 {
    /** initialize your data structure here. */
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public Offer30() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
        minStack.addFirst(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peekFirst(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int min() {
        return minStack.peekFirst();
    }
}
