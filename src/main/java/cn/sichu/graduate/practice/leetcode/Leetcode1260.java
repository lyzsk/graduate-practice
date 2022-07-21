package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维转一维
 * <p>
 * 那么一维的 index = i * n + j
 * <p>
 * 每次迁移，相当于数组向右循环移动一次，
 * 
 * @author sichu
 * @date 2022/07/20
 */
public class Leetcode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            res.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j + k) % (m * n);
                res.get(idx / n).set(idx % n, grid[i][j]);
            }
        }
        return res;
    }
}
