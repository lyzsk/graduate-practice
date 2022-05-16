package cn.sichu.graduate_practice.offer;

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
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int movingCountSolution2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfsSolution2(m, n, k, visited, 0, 0, 0, 0);
    }

    private static int dfsSolution2(int m, int n, int k, boolean[][] visited, int i, int j, int si, int sj) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfsSolution2(m, n, k, visited, i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
            + dfsSolution2(m, n, k, visited, i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}
