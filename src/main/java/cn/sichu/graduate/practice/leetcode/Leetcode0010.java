package cn.sichu.graduate.practice.leetcode;

/**
 * dp[i][j] 表示： s[0, i - 1] 与 p[0][j - 1] 是否匹配
 * <p>
 * 状态转移分情况讨论:
 * <ul>
 * <li>当 p[j - 1] 不是 '*' 时：
 * <ol>
 * <li>若 s[i - 1] == p[j - 1]时， 即 p[j - 1] 是 'a'-'z'且与 s[i - 1] 相等， dp[i][j] = dp[i - 1][j - 1]</li>
 * <li>若 s[i - 1] != p[j - 1], p[j - 1] = '.' 时， 直接将 '.'变成s[i - 1], 就与上面情况一样了</li>
 * </ol>
 * </li>
 * <li>当 p[j - 1] 是 '*' 时， 就需要根据 p[j - 2] 来判断：
 * <ol>
 * <li>当 p[j - 2] 为 'a'-'z'并且p[j - 2] == s[i - 1], 那么dp[i][j] = dp[i - 1][j], 继续看前面的s是否匹配，p暂时不动</li>
 * <li>当 p[j - 2] 为 '.' 时，可以匹配s[i - 1]前面任意字符，直接看dp[i - 1][j] 或者也可以直接返回 true;</li>
 * <li>当 p[j - 2] 为 'a'-'z'但是p[j -2] != s[i - 1], 那么当前的p作废， dp[i][j] = dp[i][j - 2]</li>
 * </ol>
 * </li>
 * </ul>
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Leetcode0010 {
    // public boolean isMatch(String s, String p) {
    // int m = s.length();
    // int n = p.length();
    // boolean[][] dp = new boolean[m + 1][n + 1];
    // dp[0][0] = true;
    // for (int i = 0; i <= m; i++) {
    // for (int j = 1; j <= n; j++) {
    // if (p.charAt(j - 1) != '*') {
    // if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
    // dp[i][j] = dp[i - 1][j - 1];
    // }
    // } else {
    // if (j >= 2 && i >= 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
    // dp[i][j] = dp[i - 1][j];
    // }
    // if (j >= 2) {
    // dp[i][j] |= dp[i][j - 2];
    // }
    // }
    // }
    // }
    // return dp[m][n];
    // }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
