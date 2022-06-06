package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 本质是1.维护单调递增栈
 * <p>
 * 2.如果已经形成单调自增栈，k还>0,继续弹出栈顶元素;
 * <p>
 * 3.生成res时，防止前导0，从双端Deque的末尾依次开始弹出最小值
 * <p>
 * 类似的题： Leetcode0316, Leetcode0321, Leetcode0402, Leetcode1081
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode0402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<Character>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekFirst() > ch) {
                deque.removeFirst();
                --k;
            }
            deque.addFirst(ch);
        }
        for (int i = 0; i < k; i++) {
            deque.removeFirst();
        }
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char ch = deque.removeLast();
            if (leadingZero && ch == '0') {
                continue;
            }
            leadingZero = false;
            res.append(ch);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
