package cn.sichu.graduate.practice.leetcode.offer;

public class Offer10II {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int f0 = 1;
        int f1 = 1;
        int fn = 2;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            fn %= (int)1e9 + 7;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
