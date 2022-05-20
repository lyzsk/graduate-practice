package cn.sichu.graduate_practice.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 频率60
 * <p>
 * https://leetcode.cn/problems/min-stack/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class MinStack {
    private Deque<Integer> dataStack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.dataStack = new ArrayDeque<Integer>();
        this.minStack = new ArrayDeque<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        dataStack.push(val);
        minStack.push(Math.min(minStack.peekFirst(), val));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}
