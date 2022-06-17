package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/06/14
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                ++i;
            }
        }
        return stack.isEmpty();
    }
}
