package cn.sichu.graduate_practice.offer;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 
 * @author sichu
 * @date 2022/04/17
 */
public class Offer10II {
    public int numWays(int n) {
        // dp0 = 1, dp1 = 1, dp2 = 2, dp3 = 3, dp4 = 5, dp5 = 8, dp6 = 13, dp7=21
        int MOD = 1000000007;
        int dp0 = 1, dp1 = 1, dp;
        for (int i = 0; i < n; i++) {
            dp = (dp0 + dp1) % MOD;
            dp0 = dp1;
            dp1 = dp;
        }
        return dp0;
    }
}
