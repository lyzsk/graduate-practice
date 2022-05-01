package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/remove-palindromic-subsequences/
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        int left = 0;
        int right = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(left) != s.charAt(right)) {
                return 2;
            }
            ++left;
            --right;
        }
        return 1;
    }
}
