package cn.sichu.graduate_practice.codetop;

/**
 * 频率43
 * <p>
 * https://leetcode.cn/problems/edit-distance/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
