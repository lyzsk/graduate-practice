package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/21
 */
public class Offer43 {
    public int countDigitOne(int n) {
        long mulk = 1;
        int res = 0;
        for (int k = 0; n >= mulk; k++) {
            res += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return res;
    }
}
