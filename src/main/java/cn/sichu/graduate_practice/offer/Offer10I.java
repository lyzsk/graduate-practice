package cn.sichu.graduate_practice.offer;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * 
 * @author sichu
 * @date 2022/04/17
 */
public class Offer10I {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param n
     * @return
     */
    public int fib(int n) {
        int MOD = 1000000007;
        int dp0 = 0, dp1 = 1, dp;
        for (int i = 0; i < n; i++) {
            dp = (dp0 + dp1) % MOD;
            dp0 = dp1;
            dp1 = dp;
        }
        return dp0;
    }
}
