package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * <p>
 * Offer link: {@link cn.sichu.graduate_practice.offerii.OfferII019}
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class ValidPalindromeII {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                ++left;
                --right;
            } else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private static boolean validPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
