package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/12
 */
public class Leetcode0509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0;
        int q = 0;
        int f = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = f;
            f = p + q;
        }
        return f;
    }
}
