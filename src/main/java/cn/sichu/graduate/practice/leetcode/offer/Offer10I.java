package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/26
 */
public class Offer10I {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int fn = 1;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            fn %= (int)1e9 + 7;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
