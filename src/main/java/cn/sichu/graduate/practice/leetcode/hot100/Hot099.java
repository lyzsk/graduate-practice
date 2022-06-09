package cn.sichu.graduate.practice.leetcode.hot100;

/**
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Hot099 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += (countPalindrome(s, i, i) + countPalindrome(s, i, i + 1));
        }
        return count;
    }

    private static int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
        return count;
    }
}
