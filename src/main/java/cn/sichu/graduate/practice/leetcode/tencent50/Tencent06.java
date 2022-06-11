package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent06 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x > 0)) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
