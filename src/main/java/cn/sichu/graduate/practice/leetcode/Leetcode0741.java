package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/07/09
 */
public class Leetcode0741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        f[0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; k++) {
            for (int x1 = Math.min(k, n - 1); x1 >= Math.max(k - n + 1, 0); x1--) {
                for (int x2 = Math.min(k, n - 1); x2 >= x1; x2--) {
                    int y1 = k - x1;
                    int y2 = k - x2;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        f[x1][x2] = Integer.MIN_VALUE;
                        continue;
                    }
                    int res = f[x1][x2];
                    if (x1 > 0) {
                        res = Math.max(res, f[x1 - 1][x2]);
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[x1][x2 - 1]);
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[x1 - 1][x2 - 1]);
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) {
                        res += grid[x2][y2];
                    }
                    f[x1][x2] = res;
                }
            }
        }
        return Math.max(f[n - 1][n - 1], 0);
    }
}
