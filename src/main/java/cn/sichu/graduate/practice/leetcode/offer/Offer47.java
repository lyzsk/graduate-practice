package cn.sichu.graduate.practice.leetcode.offer;

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
 * @author sichu
 * @date 2022/05/30
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
    // public int maxValue(int[][] grid) {
    // int m = grid.length;
    // int n = grid[0].length;
    // int[][] dp = new int[m + 1][n + 1];
    // for (int i = 1; i <= m; i++) {
    // for (int j = 1; j <= n; j++) {
    // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
    // }
    // }
    // return dp[m][n];
    // }
}
