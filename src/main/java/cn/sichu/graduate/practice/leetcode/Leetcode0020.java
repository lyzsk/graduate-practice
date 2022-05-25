package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0020 {
    public boolean isValid(String s) {
        if (s.length() < 2 || s.length() % 2 != 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.addFirst(arr[i]);
            } else if (stack.isEmpty() || !match(stack.removeFirst(), arr[i])) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }
}
