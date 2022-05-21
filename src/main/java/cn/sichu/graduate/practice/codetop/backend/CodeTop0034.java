package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0034 {
    public boolean isValid(String s) {
        if (s.length() < 2 || s.length() % 2 != 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<Character>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                deque.addLast(arr[i]);
            } else if (deque.isEmpty() || !isMatch(deque.pollLast(), arr[i])) {
                return false;
            }
        }
        return deque.isEmpty();
    }

    private static boolean isMatch(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }
}
