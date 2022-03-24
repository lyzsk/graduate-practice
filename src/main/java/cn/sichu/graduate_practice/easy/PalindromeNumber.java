package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 
 * @author sichu
 * @date 2022/03/24
 */
public class PalindromeNumber {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param x
     * @return
     */
    public boolean isPalindromeSolution1(int x) {
        String reverseStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reverseStr);

    }

    /**
     * O(nlogn)
     * <p>
     * O(1)
     * <p>
     * TODO: why?
     * 
     * @param x
     * @return
     */
    public boolean isPalindromeSolution2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }

        return x == reversedNum || x == reversedNum / 10;
    }
}
