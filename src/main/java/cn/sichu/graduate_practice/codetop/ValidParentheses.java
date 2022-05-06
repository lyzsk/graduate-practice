package cn.sichu.graduate_practice.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 频率15
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() < 2 || (s.length() % 2) != 0) {
            return false;
        }

        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<Character>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
                deque.addLast(arr[i]);
            } else if (deque.isEmpty() || !match(deque.pollLast(), arr[i])) {
                return false;
            }
        }
        return deque.isEmpty();
    }

    private static boolean match(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }
}
