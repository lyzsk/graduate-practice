package cn.sichu.graduate.practice.leetcode;

/**
 * 因为这题，求的是 最短路径和， 别用[m+1][n+1]为边界的，因为再Math.min()的过程中会取到虚拟边界的0，要写条件判断的话也特麻烦， 尝试了下没写出来也没搜到...建议以后都用[m][n]边界判断
 * <p>
 * 类似的题: Leetcode0064, Leetcode1143, Leetcode0221, Leetcode1277
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
public class Leetcode0064 {
    public int minPathSum(int[][] grid) {
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
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
