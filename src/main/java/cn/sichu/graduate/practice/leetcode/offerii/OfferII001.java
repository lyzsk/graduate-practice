package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class OfferII001 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int res = 0;
        while (a <= b) {
            a -= b;
            ++res;
        }
        return sign == 1 ? res : -res;
    }
}
