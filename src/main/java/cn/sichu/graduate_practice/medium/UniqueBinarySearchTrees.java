package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class UniqueBinarySearchTrees {
    /**
     * f(i,n) = dp(i - 1) * dp(n - i)
     * <p>
     * n = 3; dp(2) * dp(0) + dp(1)*dp(1);
     * <p>
     * n = 2; dp(1) * dp(0) + dp(0) * dp(1);
     * <p>
     * O(n<sup>2</sup>)
     * <p>
     * O(n)
     * 
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
