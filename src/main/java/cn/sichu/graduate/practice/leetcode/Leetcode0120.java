package cn.sichu.graduate.practice.leetcode;

import java.util.List;

/**
 * @author sichu
 * @date 2022/06/13
 */
public class Leetcode0120 {
    // public int minimumTotal(List<List<Integer>> triangle) {
    // int n = triangle.size();
    // int[][] dp = new int[n + 1][n + 1];
    // for (int i = n - 1; i >= 0; i--) {
    // for (int j = 0; j <= i; j++) {
    // dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
    // }
    // }
    // return dp[0][0];
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
