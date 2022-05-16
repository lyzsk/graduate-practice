package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }

    private static int dfs(int m, int n, int k, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || visited[i][j] || bitSum(i) + bitSum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(m, n, k, visited, i + 1, j) + dfs(m, n, k, visited, i, j + 1);
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
