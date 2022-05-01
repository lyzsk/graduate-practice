package cn.sichu.graduate_practice.offerii;

/**
 * https://leetcode-cn.com/problems/a7VOhD/
 * <p>
 * same: {@link cn.sichu.graduate_practice.medium.PalindromicSubstrings}
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class OfferII020 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                if (dp[i][j]) {
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * 比方法1快
     * 
     * @param s
     * @return
     */
    public int countSubstringsSolution2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private static int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
        return count;
    }
}
