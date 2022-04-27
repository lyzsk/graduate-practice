package cn.sichu.graduate_practice;

/**
 * Write an efficient Haskell function nlcc l v that finds the number of elements in the largest connected component of
 * the binary image (list of lists) l for the value v.
 * 
 * @author sichu
 * @date 2022/04/24
 */
public class Cmt304p2 {
    public int nlcc(int[][] grid, int value) {
        int res = 0;
        for (int i = 0; i != grid.length; i++) {
            for (int j = 0; j != grid[0].length; j++) {
                if (grid[i][j] == value) {
                    res = Math.max(res, dfs(grid, i, j, value));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int cur_i, int cur_j, int value) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != value) {
            return 0;
        }
        grid[cur_i][cur_j] = -1;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int res = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            res += dfs(grid, next_i, next_j, value);
        }
        return res;
    }

}
