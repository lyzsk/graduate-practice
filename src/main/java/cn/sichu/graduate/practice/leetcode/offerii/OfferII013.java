package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * @author sichu
 * @date 2022/07/21
 */
public class OfferII013 {
    private int[][] presum;

    public OfferII013(int[][] matrix) {
        if (matrix.length > 0) {
            presum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    presum[i + 1][j + 1] = presum[i][j + 1] + presum[i + 1][j] - presum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
    }
}
