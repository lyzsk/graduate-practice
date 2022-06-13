package cn.sichu.graduate.practice.leetcode;

/**
 * 一共有 m + n - 1 条对角线
 * <p>
 * 对角线从下往上遍历时, 每次 row - 1, col + 1，直到边缘
 * <p>
 * 对角线从上往下遍历时， 每次 row + 1, col - 1
 * 
 * @author sichu
 * @date 2022/06/13
 */
public class Leetcode0489 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if ((i & 1) == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    ++pos;
                    ++x;
                    --y;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    ++pos;
                    --x;
                    ++y;
                }
            }
        }
        return res;
    }
}
