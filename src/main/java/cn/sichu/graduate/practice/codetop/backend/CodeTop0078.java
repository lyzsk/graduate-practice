package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0078 {
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
