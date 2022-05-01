package cn.sichu.graduate_practice.interview;

/**
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class Interview0104 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            ++count[arr[i]];
        }

        int countOdd = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                if (++countOdd > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
