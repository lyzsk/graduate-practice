package cn.sichu.graduate_practice.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 频率34
 * <p>
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class MyQueue {
    private Deque<Integer> stack1 = new ArrayDeque<Integer>();
    private Deque<Integer> stack2 = new ArrayDeque<Integer>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        move();
        return stack2.pop();
    }

    public int peek() {
        move();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void move() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * <p>
 * MyQueue obj = new MyQueue();
 * <p>
 * obj.push(x);
 * <p>
 * int param_2 = obj.pop();
 * <p>
 * int param_3 = obj.peek();
 * <p>
 * boolean param_4 = obj.empty();
 * <p>
 */