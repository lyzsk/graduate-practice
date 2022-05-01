package cn.sichu.graduate_practice.offerii;

/**
 * https://leetcode-cn.com/problems/RQku0D/
 * <p>
 * same: {@link cn.sichu.graduate_practice.easy.ValidPalindromeII}
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class OfferII019 {
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

    /**
     * 用while left < right， 比 for(i = left, j = right) 慢2ms
     * 
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static boolean validPalindrome(String s, int left, int right) {
        // while (left < right) {
        // if (s.charAt(left) != s.charAt(right)) {
        // return false;
        // }
        // ++left;
        // --right;
        // }
        // return true;
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(left) != s.charAt(j)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
