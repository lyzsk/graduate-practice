package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target > matrix[i][j]) {
                ++j;
            } else if (target < matrix[i][j]) {
                --i;
            } else {
                return true;
            }
        }
        return false;
    }
}
