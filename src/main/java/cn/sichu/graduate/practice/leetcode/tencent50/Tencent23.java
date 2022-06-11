package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * 1jie: 1
 * <p>
 * 2jie: 2
 * <p>
 * 3jie: 3
 * <p>
 * 4jie: 5
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent23 {
    public int climbStairs(int n) {
        int f0 = 0;
        int f1 = 0;
        int dp = 1;
        for (int i = 1; i <= n; i++) {
            f0 = f1;
            f1 = dp;
            dp = f0 + f1;
        }
        return dp;
    }
}
