package cn.sichu.graduate_practice.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * 
 * @author sichu
 * @date 2022/04/28
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        // 当 ch 是数字，将数字字符转化为int型的 multi ， 用于倍数计算
        int multi = 0;
        Deque<Integer> multiStack = new ArrayDeque<Integer>();
        Deque<String> resStack = new ArrayDeque<String>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = arr[i];
            if (ch == '[') {
                multiStack.addLast(multi);
                resStack.addLast(res.toString());
                // 当ch=='[', 将当前的 multi && res 入栈，并置空
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
                // ch - '0' == Integer.parseInt(ch + "")
                multi = multi * 10 + (ch - '0');
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
