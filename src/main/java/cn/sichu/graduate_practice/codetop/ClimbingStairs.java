package cn.sichu.graduate_practice.codetop;

/**
 * 频率37
 * <p>
 * https://leetcode.cn/problems/climbing-stairs/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
