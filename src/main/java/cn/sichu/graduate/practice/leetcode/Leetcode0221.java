package cn.sichu.graduate.practice.leetcode;

/**
 * 这道题的 dp[i][j] 代表的是 <b>以[i, j]为右下角 && 只包含 '1' 的正方形的边长最大值</b>，
 * <p>
 * 所以要用 Math.min() 判断 left, top, corner 的最小值， 这里的最小意味着可行性; 然后再用 maxSide 再次 Math.max() 判断全局最大值
 * <p>
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
public class Leetcode0221 {
    /**
     * 也可以把双层for循环边界改成从 i = 0, j = 0 开始，
     * <p>
     * 省略 第一行和第一列的初始化，并且在循环体里判断 (i == 0 || j == 0) 的情况 和 其他正常dp情况， 省略了重复的 maxSide 的判断，
     * <p>
     * 但是好像并没提升效率，不方便套模板和理解
     * 
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int maxSide = matrix[0][0] == '1' ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    // public int maximalSquare(char[][] matrix) {
    // int maxSide = 0;
    // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    // return maxSide;
    // }
    // int rows = matrix.length;
    // int cols = matrix[0].length;
    // int[][] dp = new int[rows][cols];
    // for (int i = 0; i < rows; i++) {
    // for (int j = 0; j < cols; j++) {
    // if (matrix[i][j] == '1') {
    // if (i == 0 || j == 0) {
    // dp[i][j] = 1;
    // } else {
    // dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
    // }
    // maxSide = Math.max(maxSide, dp[i][j]);
    // }
    // }
    // }
    // int res = maxSide * maxSide;
    // return res;
    // }
}
