package cn.sichu.graduate.practice.leetcode;

/**
 * 类似的题: Offer47, Leetcode0064, Leetcode1143, Leetcode0221
 * <p>
 * 都是既可以选择，{@code int[][] dp = new int[m][n]} 和 {@code int[][] dp = new int[m + 1][n + 1]}
 * <p>
 * <ul>
 * <li>选择[m][n]为边界时， 需要从 {@code i = 1; i < m; i++} 和 {@code i = 1; i < n; i++} 初始化第一行和第一列的值，再进入 双层for循环，此时for循环边界是
 * {@code < m} 和 {@code < n};</li>
 * <li>选择[m+1][n+1]为边界时， 直接进入双层for循环，此时for循环边界是 {@code <= m} 和 {@code <= n};</li>
 * </ul>
 * 
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode1143 {
    /**
     * 因为这道题多了一个判断 text1.charAt(i - 1) == text2.charAt(j - 1) 的操作，直接进入双层for循环会比用 [m][n] 快
     * <p>
     * 但说实话，还是用 模板式的方法，比较直观清晰，方便理解，也不容易出错
     * 
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = text2.charAt(i) == text1.charAt(0) ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int corner = text1.charAt(i) == text2.charAt(j) ? dp[i - 1][j - 1] + 1 : dp[i - 1][j - 1];
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                dp[i][j] = Math.max(corner, Math.max(left, top));
            }
        }
        return dp[m - 1][n - 1];
    }
    /**
     * @param text1
     * @param text2
     * @return
     */
    // public int longestCommonSubsequence(String text1, String text2) {
    // int m = text1.length();
    // int n = text2.length();
    // int[][] dp = new int[m + 1][n + 1];
    // for (int i = 1; i <= m; i++) {
    // for (int j = 1; j <= n; j++) {
    // if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
    // dp[i][j] = dp[i - 1][j - 1] + 1;
    // } else {
    // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    // }
    // }
    // }
    // return dp[m][n];
    // }
}
