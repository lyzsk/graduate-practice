package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class ClimbingStairs {
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
