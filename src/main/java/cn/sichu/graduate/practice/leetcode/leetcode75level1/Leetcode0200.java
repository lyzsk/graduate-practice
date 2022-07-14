package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/12
 */
public class Leetcode0200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    ++res;
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == '0') {
            return;
        }
        if (!visited[x][y]) {
            visited[x][y] = true;
            grid[x][y] = '0';
            dfs(grid, visited, x - 1, y);
            dfs(grid, visited, x + 1, y);
            dfs(grid, visited, x, y - 1);
            dfs(grid, visited, x, y + 1);
        }
    }
}
