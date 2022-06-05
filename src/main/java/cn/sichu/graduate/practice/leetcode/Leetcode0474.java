package cn.sichu.graduate.practice.leetcode;

/**
 * dp[i][j][k] -> 前i件物品，在数字0容量<=j ,数字1容量<=k 的条件下的 最大价值
 * <p>
 * 0-1背包： Leetcode0416, Leetcode0474, Leetcode0494, Leetcode0879, Leetcode1049
 * <p>
 * 完全背包： Leetcode0322, Leetcode0518, Leetcode1449, Leetcode0279
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode0474 {
    // public int findMaxForm(String[] strs, int m, int n) {
    // int[][][] dp = new int[strs.length][m + 1][n + 1];
    // for (int i = 1; i <= strs.length; i++) {
    // int[] zerosOnes = getZerosOnes(strs[i - 1]);
    // int zeros = zerosOnes[0];
    // int ones = zerosOnes[1];
    // for (int j = 0; j <= m; j++) {
    // for (int k = 0; k <= n; k++) {
    // dp[i][j][k] = dp[i - 1][j][k];
    // if (j >= zeros && k >= ones) {
    // dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
    // }
    // }
    // }
    // }
    // return dp[strs.length][m][n];
    // }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0];
            int ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        for (int i = 0; i < str.length(); i++) {
            ++zerosOnes[str.charAt(i) - '0'];
        }
        return zerosOnes;
    }
}
