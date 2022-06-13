package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/06/13
 */
public class Leetcode2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
