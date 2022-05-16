package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/island-perimeter/
 * 
 * @author sichu
 * @date 2022/05/14
 */
public class IslandPerimeter {
    public int islandPerimeterSolution1(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid, row, col);
                }
            }
        }
        return 0;
    }

    private static int dfs(int[][] grid, int row, int col) {
        if (!(0 <= row && row < grid.length && 0 <= col && col < grid[0].length)) {
            return 1;
        }
        if (grid[row][col] == 0) {
            return 1;
        }
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = -1;

        return dfs(grid, row - 1, col) + dfs(grid, row + 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public int islandPerimeterSolution2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res += dfs(i, j, grid, n, m);
                }
            }
        }
        return res;
    }

    private static int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == -1) {
            return 0;
        }
        grid[x][y] = -1;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }
}
