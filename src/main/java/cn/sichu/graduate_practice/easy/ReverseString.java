package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 
 * @author sichu
 * @date 2022/04/05
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            ++left;
            --right;
        }
    }
}
