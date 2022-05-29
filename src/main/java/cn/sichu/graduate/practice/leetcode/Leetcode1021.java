package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/28
 */
public class Leetcode1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                stack.removeFirst();
            }
            if (!stack.isEmpty()) {
                res.append(arr[i]);
            }
            if (arr[i] == '(') {
                stack.addFirst(arr[i]);
            }
        }
        return res.toString();
    }
}
