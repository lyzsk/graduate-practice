package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] < target) {
                ++x;
            } else if (matrix[x][y] > target) {
                --y;
            } else {
                return true;
            }
        }
        return false;
    }
}
