package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class Offer19 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (j >= 2 && i >= 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
