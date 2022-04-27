package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 
 * @author sichu
 * @date 2022/04/08
 */
public class LongestPalindrome {
    // public int longestPalindrome(String s) {
    // int[] count = new int[128];
    //
    // for (char ch : s.toCharArray()) {
    // ++count[ch];
    // }
    //
    // int countOdd = 0;
    // for (int i : count) {
    // if (i % 2 != 0) {
    // ++countOdd;
    // }
    // }
    // return countOdd == 0 ? s.length() : (s.length() - countOdd + 1);
    // }

    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[58];
        for (int i = 0; i < arr.length; i++) {
            ++count[arr[i] - 'A'];
        }

        int countOdd = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                ++countOdd;
            }
        }
        return countOdd == 0 ? s.length() : (s.length() - countOdd + 1);
    }
}
