package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent49 {
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
