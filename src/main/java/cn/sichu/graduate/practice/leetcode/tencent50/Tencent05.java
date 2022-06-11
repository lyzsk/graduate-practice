package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent05 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        while (s.charAt(i) == ' ') {
            ++i;
            if (i == s.length()) {
                return 0;
            }
        }
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            ++i;
        }
        int res = 0;
        int flag = Integer.MAX_VALUE / 10;
        for (; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            if (res > flag || (res == flag && s.charAt(i) > '7')) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }
}
