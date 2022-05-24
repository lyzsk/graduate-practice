package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0087 {
    public boolean searchMatrix(int[][] matrix, int target) {
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
