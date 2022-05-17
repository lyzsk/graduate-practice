package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/count-sub-islands/
 * 
 * @author sichu
 * @date 2022/05/17
 */
public class CountSubIslands {
    /**
     * 只要grid2的岛屿在grid1上是水域的话，就不是子岛屿，所以只需要判断是不是水域就完事了
     * 
     * @param grid1
     * @param grid2
     * @return
     */
    private boolean flag;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    flag = true;
                    dfs(grid1, grid2, i, j);
                    if (flag) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x > grid2.length - 1 || y > grid2[0].length - 1 || grid2[x][y] == 0) {
            return;
        }
        grid2[x][y] = 0;
        if (grid1[x][y] == 0) {
            flag = false;
        }
        dfs(grid1, grid2, x - 1, y);
        dfs(grid1, grid2, x + 1, y);
        dfs(grid1, grid2, x, y - 1);
        dfs(grid1, grid2, x, y + 1);
    }
}
