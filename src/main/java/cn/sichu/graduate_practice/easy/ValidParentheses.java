package cn.sichu.graduate_practice.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 
 * @author sichu
 * @date 2022/03/27
 */
public class ValidParentheses {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if ((s.length() % 2) != 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque();

        for (int i = 0; i < chars.length; i++) {
            boolean left = (chars[i] == '[' || chars[i] == '{' || chars[i] == '(');

            if (left) {
                q.push(chars[i]);
            } else if (q.isEmpty() || !match(q.pop(), chars[i])) {
                return false;
            }
        }

        return q.isEmpty();
    }

    private boolean match(char left, char right) {
        return (left == '[' && right == ']' || left == '{' && right == '}' || left == '(' && right == ')');
    }
}
