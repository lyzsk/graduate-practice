package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {};
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                res[index] = matrix[top][col];
                ++index;
            }
            for (int row = top + 1; row <= bottom; row++) {
                res[index] = matrix[row][right];
                ++index;
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    res[index] = matrix[bottom][col];
                    ++index;
                }
                for (int row = bottom; row > top; row--) {
                    res[index] = matrix[row][left];
                    ++index;
                }
            }
            ++left;
            --right;
            ++top;
            --bottom;
        }
        return res;
    }
}
