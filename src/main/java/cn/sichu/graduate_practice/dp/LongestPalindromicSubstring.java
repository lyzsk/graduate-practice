package cn.sichu.graduate_practice.dp;

/**
 * @see <a href = "https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * @author sichu
 * @date 2022/03/23
 */
public class LongestPalindromicSubstring {
    /**
     * dp 不是最优的
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        /**
         * 长度为1的子串一定是回文串
         */
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        /**
         * 枚举子串的长度,要用到string.toCharArray
         */
        int start = 0;
        int end = 1;
        // int maxLen = 1;
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= s.length(); L++) {
            for (int left = 0; left < s.length(); left++) {
                /**
                 * L = right - left + 1
                 */
                int right = L + left - 1;
                if (right > s.length() - 1) {
                    break;
                }

                if (charArray[left] == (charArray[right])) {
                    if (right - left + 1 <= 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] /* && right - left + 1 > maxLen */) {
                    // maxLen = right - left + 1;
                    start = left;
                    end = start + (right - left + 1);
                }
            }
        }
        return s.substring(start, /*start + maxLen*/end);
    }
}
