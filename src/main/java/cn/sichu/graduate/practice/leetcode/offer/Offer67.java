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
        int start = i;
        int sign = 1;
        int res = 0;
        for (; i < str.length(); i++) {
            if (i == start && str.charAt(i) == '+') {
                sign = 1;
            } else if (i == start && str.charAt(i) == '-') {
                sign = -1;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && -(str.charAt(i) - '0') < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * (str.charAt(i) - '0');
            } else {
                break;
            }
        }
        return res;
    }
}
