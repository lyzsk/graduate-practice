package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/max-area-of-island/
 * 
 * @author sichu
 * @date 2022/05/17
 */
public class MaxAreaOfIsland {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            res += dfs(grid, mx, my);
        }
        return res;
    }
}
