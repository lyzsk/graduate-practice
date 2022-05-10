package cn.sichu.graduate_practice.codetop;

/**
 * 频率46
 * <p>
 * https://leetcode.cn/problems/string-to-integer-atoi/
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return 0;
        }

        int i = 0;
        while (s.charAt(i) == ' ') {
            ++i;
            if (i == n) {
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
        for (; i < n; i++) {
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
