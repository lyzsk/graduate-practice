package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent04 {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int res = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if (res > max / 10 || res < min / 10 || (res == max / 10 && lastDigit > max % 10)
                || (res == min / 10 && lastDigit < min % 10)) {
                return 0;
            }
            x /= 10;
            res = res * 10 + lastDigit;
        }
        return res;
    }
}
