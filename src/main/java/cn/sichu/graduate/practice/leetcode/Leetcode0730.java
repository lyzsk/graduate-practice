package cn.sichu.graduate.practice.leetcode;

/**
 * dp[i][j] 代表 s[i..j] 的回文子序列数量
 * <p>
 * 初始情况 dp[i][j] = 1; dp[i][i + 1] = 2
 * <ul>
 * <li>当 s[i] != s[i + 1] 时， 就是两个单独的字符，独自构成回文</li>
 * <li>当 s[i] == s[i + 1] 时， 就是一个字符的回文，和两个字符在一起的回文</li>
 * </ul>
 * dp[i][j] 状态转移分情况讨论：
 * <ul>
 * <li>当 s[i] != s[j] 时，即两端不是同一字符， dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]</li>
 * <ul>
 * <li>比如 "bcc", 两端不同，dp[0][2] = dp[1][2] + dp[0][1] - dp[1][1] = 2 + 2 - 1 = 3: "b", "c", "cc", dp[i + 1][j -
 * 1]代表的是重复内容</li>
 * </ul>
 * <li>当 s[i] == s[j] 时， dp[i][j] = 2 * dp[i + 1][j - 1]</li>
 * <ul>
 * <li>当 s[i] 不再重复出现在 s[i + 1...j - 1] 中时，不变</li>
 * <li>当 s[i] 还会再次出现在 s[i + 1...j - 1] 中时， 去重: dp[i][j] -= dp[left + 1][right - 1]， left和right 代表最左和最右的出现下标</li>
 * </ul>
 * </ul>
 * 参考:<a href =
 * "">https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/2006142/Java-DP-with-Detailed-Explanation</a>
 * 
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Leetcode0730 {
    public int countPalindromicSubsequences(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        long[][] dp = new long[s.length()][s.length()];
        long mod = (long)(1e9 + 7);
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (arr[i] != arr[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 2 * dp[i + 1][j - 1];
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && arr[left] != arr[i]) {
                        ++left;
                    }
                    while (left <= right && arr[right] != arr[i]) {
                        --right;
                    }
                    if (left > right) {
                        dp[i][j] += 2;
                    } else if (left == right) {
                        dp[i][j] += 1;
                    } else {
                        dp[i][j] -= dp[left + 1][right - 1];
                    }
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int)dp[0][s.length() - 1];
    }
}
