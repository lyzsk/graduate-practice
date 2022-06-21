package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/21
 */
public class Offer14II {
    // public int cuttingRope(int n) {
    // if (n <= 3) {
    // return n - 1;
    // }
    // int a = n / 3;
    // int b = n % 3;
    // int mod = (int)1e9 + 7;
    // if (b == 0) {
    // return (int)Math.pow(3, a);
    // }
    // if (b == 1) {
    // return (int)Math.pow(3, a - 1) * 4;
    // }
    // return (int)Math.pow(3, a) * 2;
    // }
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1L;
        int mod = (int)1e9 + 7;
        while (n > 4) {
            res = res * 3 % mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }
}
