package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0066 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
