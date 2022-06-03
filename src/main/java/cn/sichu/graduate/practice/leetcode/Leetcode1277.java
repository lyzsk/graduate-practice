package cn.sichu.graduate.practice.leetcode;

/**
 * 注意，循环体内，当matrix[i][j] == 1 时，要更新 matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j
 * - 1])) + 1;
 * <p>
 * 本质还是用dp[i][j] 存放 以 [i,j] 为右下角 && 只包含 '1' 的正方形的边长最大值, 然后每次 res += dp[i][j]， 然而没必要浪费空间去存dp直接删了就好
 * <p>
 * 类似的题: Leetcode0064, Leetcode1143, Leetcode0221, Leetcode1277
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Leetcode1277 {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = matrix[0][0] == 1 ? 1 : 0;
        for (int i = 1; i < rows; i++) {
            res += matrix[i][0] == 1 ? 1 : 0;
        }
        for (int i = 1; i < cols; i++) {
            res += matrix[0][i] == 1 ? 1 : 0;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    res += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
            }
        }
        return res;
    }
}
