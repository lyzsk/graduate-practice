package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * @author sichu
 * @date 2022/06/24
 */
public class OfferII091 {
    // public int minCost(int[][] costs) {
    // int n = costs.length;
    // int[][] dp = new int[n][3];
    // dp[0][0] = costs[0][0];
    // dp[0][1] = costs[0][1];
    // dp[0][2] = costs[0][2];
    // for (int i = 1; i < n; i++) {
    // dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
    // dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
    // dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
    // }
    // return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    // }

    public int minCost(int[][] costs) {
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
}
