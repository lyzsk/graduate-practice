package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, k, 0, 0);
    }

    private static int dfs(boolean[][] visited, int m, int n, int k, int x, int y) {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || visited[x][y] || bitSum(x) + bitSum(y) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(visited, m, n, k, x + 1, y) + dfs(visited, m, n, k, x, y + 1);
    }

    private static int bitSum(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
