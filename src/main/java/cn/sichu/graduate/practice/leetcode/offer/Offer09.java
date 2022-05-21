package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class Offer09 {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public Offer09() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        inStack.addFirst(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2out();
        }
        return outStack.removeFirst();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.addFirst(inStack.removeFirst());
        }
    }
}
