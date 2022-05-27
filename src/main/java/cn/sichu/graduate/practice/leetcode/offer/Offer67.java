package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/26
 */
public class Offer67 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        while (str.charAt(i) == ' ') {
            ++i;
            if (i == str.length()) {
                return 0;
            }
        }
        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            ++i;
        }
        int res = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10
                || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        return sign * res;
    }
}
