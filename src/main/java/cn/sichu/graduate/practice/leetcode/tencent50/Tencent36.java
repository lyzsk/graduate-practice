package cn.sichu.graduate.practice.leetcode.tencent50;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent36 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public Tencent36() {
        this.stack = new ArrayDeque<Integer>();
        this.minStack = new ArrayDeque<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peekFirst()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}
