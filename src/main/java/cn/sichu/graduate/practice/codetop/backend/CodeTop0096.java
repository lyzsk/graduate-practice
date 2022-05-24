package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0096 {
    /**
     * 当 ch 是数字，将数字字符转化为int型的 multi ， 用于倍数计算
     * <p>
     * 当ch=='[', 将当前的 multi && res 入栈，并置空
     * 
     * @param s
     * @return res.toString();
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque<Integer> multiStack = new ArrayDeque<Integer>();
        Deque<String> resStack = new ArrayDeque<String>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = arr[i];
            if (ch == '[') {
                multiStack.addLast(multi);
                resStack.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = multiStack.removeLast();
                for (int j = 0; j < curMulti; j++) {
                    tmp.append(res);
                }
                res = new StringBuilder(resStack.removeLast() + tmp);
            } else if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + (ch - '0');
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
