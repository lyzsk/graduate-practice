package cn.sichu.graduate_practice.offerii;

/**
 * https://leetcode-cn.com/problems/ZL6zAn/
 * 
 * @author sichu
 * @date 2022/04/23
 */
public class OfferII105 {
    /**
     * dfs, O(mn)
     * <p>
     * O(mn)
     * 
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i != grid.length; i++) {
            for (int j = 0; j != grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int res = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            res += dfs(grid, next_i, next_j);
        }
        return res;
    }

}
