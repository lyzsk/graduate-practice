package cn.sichu.graduate_practice.offerii;

/**
 * https://leetcode-cn.com/problems/XltzEq/
 * <p>
 * 一样:{@link cn.sichu.graduate_practice.easy.ValidPalindrome}
 * 
 * @author sichu
 * @date 2022/04/30
 */
public class OfferII018 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
