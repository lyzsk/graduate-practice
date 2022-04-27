package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 
 * @author sichu
 * @date 2022/04/27
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;

                if (len == 1) {
                    dp[left][right] = 1;
                } else if (len == 2) {
                    dp[left][right] = (arr[left] == arr[right]) ? 2 : 1;
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                    dp[left][right] =
                        Math.max(dp[left][right], dp[left + 1][right - 1] + (arr[left] == arr[right] ? 2 : 0));
                }
            }
        }

        return dp[0][n - 1];
    }

    /**
     * O(n<sup>2</sup>)
     * <p>
     * O(n<sup>2</sup>)
     * 
     * @param s
     * @return
     */
    public int longestPalindromeSubseqSolution2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char ch1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char ch2 = s.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
