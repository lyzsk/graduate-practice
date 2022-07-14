package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/14
 */
public class Leetcode0070 {
    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
