package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0081 {

    private Deque<Integer> nums = new ArrayDeque<Integer>();
    private Deque<Character> operators = new ArrayDeque<Character>();
    private Map<Character, Integer> map = new HashMap<Character, Integer>();

    /**
     * {@code s = '0' + s;} 可以防止 s 的第一个元素是负数
     * <p>
     * {@code Map<Character, Integer> map = new HashMap<Character, Integer>();} 储存运算符的优先级
     * 
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = '0' + s;
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                int x = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j) - '0';
                    ++j;
                }
                i = j - 1;
                nums.addFirst(x);
            } else {
                while (!operators.isEmpty() && map.get(operators.peekFirst()) >= map.get(ch)) {
                    eval();
                }
                operators.addFirst(ch);
            }
        }
        while (!operators.isEmpty()) {
            eval();
        }
        return nums.peekFirst();
    }

    private void eval() {
        int num2 = nums.removeFirst();
        int num1 = nums.removeFirst();
        char operator = operators.removeFirst();
        int res = 0;
        if (operator == '+') {
            res = num1 + num2;
        } else if (operator == '-') {
            res = num1 - num2;
        } else if (operator == '*') {
            res = num1 * num2;
        } else {
            res = num1 / num2;
        }
        nums.addFirst(res);
    }
}
