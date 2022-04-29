package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 
 * @author sichu
 * @date 2022/04/29
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }

                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
                if (dp[i][j]) {
                    ++count;
                }
            }
        }
        return count;
    }
}
