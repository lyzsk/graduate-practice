package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0032 {
    public int longestValidParentheses(String s) {
        int res = 0;
        if (s.length() < 2) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addFirst(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addFirst(i);
            } else {
                stack.removeFirst();
                if (stack.isEmpty()) {
                    stack.addFirst(i);
                } else {
                    res = Math.max(res, i - stack.peekFirst());
                }
            }
        }
        return res;
    }
}
